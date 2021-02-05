package com.hanko.auth.services;
import com.hanko.cmn.constant.ServiceConstants;
import com.hanko.cmn.model.Result;
import com.hanko.cmn.model.SysUserDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lengleng
 * @date 2019/2/1
 */
@FeignClient(contextId = "remoteUserService",
		value = ServiceConstants.ADMIN_SERVICE,
		url = "http://localhost:8001")
public interface RemoteUserService {

	/**
	 * 通过用户名查询用户、角色信息
	 * @param username 用户名
	 * @return R
	 */
	@GetMapping("/user/details/{username}")
	Result<SysUserDetails> getUserDetailsByUsername(@PathVariable("username") String username);


}
