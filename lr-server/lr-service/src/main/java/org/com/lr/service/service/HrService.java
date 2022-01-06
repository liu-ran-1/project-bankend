package org.com.lr.service.service;

import com.alibaba.druid.util.StringUtils;
import org.com.lr.mapper.HrMapper;
import org.com.lr.mapper.HrRoleMapper;
import org.com.lr.model.Hr;
import org.com.lr.model.RespBean;
import org.com.lr.service.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-09-20 8:21
 */
@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;
    @Autowired
    HrRoleMapper hrRoleMapper;

    @Autowired
    MenuService menuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHrs(String keywords) {
        return hrMapper.getAllHrs(HrUtils.getCurrentHr().getId(),keywords);
    }

    public Integer updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        hrRoleMapper.deleteByHrid(hrid);
        return hrRoleMapper.addRole(hrid, rids) == rids.length;
    }

    public Integer deleteHrById(Integer id) {
        return hrMapper.deleteByPrimaryKey(id);
    }

    public List<Hr> getAllHrsExceptCurrentHr() {
        return hrMapper.getAllHrsExceptCurrentHr(HrUtils.getCurrentHr().getId());
    }

    public Integer updateHyById(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    public boolean updateHrPasswd(String oldpass, String pass, Integer hrid) {
        Hr hr = hrMapper.selectByPrimaryKey(hrid);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(oldpass, hr.getPassword())) {
            String encodePass = encoder.encode(pass);
            Integer result = hrMapper.updatePasswd(hrid, encodePass);
            if (result == 1) {
                return true;
            }
        }
        return false;
    }

    public Integer updateUserface(String url, Integer id) {
        return hrMapper.updateUserface(url, id);
    }

    public RespBean register(Hr hr) {
        boolean checkResult = this.checkHrInfo(hr);
        if(!checkResult){
            return RespBean.error("缺少必传字段值!");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String enpassword = encoder.encode(hr.getPassword());
        hr.setPassword(enpassword);
        this.doRetister(hr);
        return RespBean.build().setStatus(200).setObj(hr).setMsg("注册成功");
    }

    /*
    验证必须传字段是否传了
     */
    private boolean checkHrInfo(Hr hr) {
        if(hr == null ||
        StringUtils.isEmpty(hr.getPassword()) || StringUtils.isEmpty(hr.getUsername()) ||
         StringUtils.isEmpty(hr.getPhone())){
            return false;
        }
        return true;
    }

    private void doRetister(Hr hr) {
        hr.setEnabled(true);
        hrMapper.insert(hr);
    }
}
