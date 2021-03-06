package com.leoman.admin.controller;

import com.leoman.admin.entity.Admin;
import com.leoman.admin.service.AdminService;
import com.leoman.admin.service.impl.AdminServiceImpl;
import com.leoman.common.controller.common.GenericEntityController;
import com.leoman.common.factory.DataTableFactory;
import com.leoman.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/6/13.
 */
@Controller
@RequestMapping(value = "/admin/admin")
public class AdminController extends GenericEntityController<Admin,Admin,AdminServiceImpl> {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/index")
    public String index(){
        return "/admin/list";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(Integer draw, Integer start, Integer length,Admin admin){
        Page<Admin> page = null;
        try {
            int pagenum = getPageNum(start,length);
            page = adminService.findAll(admin, pagenum, length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DataTableFactory.fitting(draw,page);
    }

    @RequestMapping(value = "/add")
    public String edit(Long id, Model model){
        try {
            if(id !=null){
                Admin admin = adminService.queryByPK(id);
                model.addAttribute("admin",admin);
             }
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return "/admin/add";
     }

//    @RequestMapping(value = "/status")
//    @ResponseBody
//    public Result status(Long id){
//            Admin admin = adminService.queryByPK(id);
//            Integer status = admin.getStatus();
//            try{
//                if(status == 0) {
//                    admin.setStatus(1);
//                    adminService.save(admin);
//                }else {
//                    admin.setStatus(0);
//                    adminService.save(admin);
//                }
//            }catch (RuntimeException e){
//                e.printStackTrace();
//                return Result.failure();
//            }
//            return Result.success();
//        }
}
