package com.lin.cangkusp.controller;

import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.constant.ConResult;
import com.lin.cangkusp.common.utils.ExcelUtils;
import com.lin.cangkusp.common.utils.QueryCargoVo;
import com.lin.cangkusp.pojo.Cargo;
import com.lin.cangkusp.service.CargoService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CargoController {
    @Autowired
    private CargoService cargoService;

    @RequestMapping("cargo/search")
    @ResponseBody
    public PageInfo<Cargo> queryCargoByExample(QueryCargoVo queryCargoVo, int pageNum, int pageSize) {
        return cargoService.queryCargoByExample(queryCargoVo, pageNum, pageSize);
    }

    @RequestMapping("cargo/insert")
    @ResponseBody
    public ConResult insertCargo(Cargo cargo) {
        cargoService.insertCargo(cargo);
        return ConResult.ok();
    }

    @RequestMapping("cargo/update")
    @ResponseBody
    public ConResult updateCargo(Cargo cargo) {
        cargoService.updateCargo(cargo);
        return ConResult.ok();
    }

    @RequestMapping("cargo/delete")
    @ResponseBody
    public ConResult deleteCargo(Cargo cargo) {

        cargoService.deleteCargo(cargo);
        return ConResult.ok();
    }

    @RequestMapping("/cargo/{id}")
    @ResponseBody
    public Cargo queryCargoById(@PathVariable String id) {
        return cargoService.queryCargoById(id);
    }

    @RequestMapping("cargo/export")
    @ResponseBody
    public void exportCargo(HttpServletRequest request, HttpServletResponse response,
                            QueryCargoVo queryCargoVo) {
        PageInfo<Cargo> cargoPageInfo = cargoService.queryCargoByExample(queryCargoVo, 0, 0);

        if (cargoPageInfo.getSize()==0){
            return;
        }

        String[] title = {"货物编号", "货物名称", "单价", "供应商编号"};

        String fileName = "货物信息表" + ".xls";

        String sheetName = "货物信息";

        List<List<String>> lists = new ArrayList<>();
        for (Cargo cargo : cargoPageInfo.getList()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(cargo.getCno());
            list.add(cargo.getCname());
            list.add(String.valueOf(cargo.getCprice()));
            list.add(cargo.getPno());
            lists.add(list);
        }

        HSSFWorkbook workbook = ExcelUtils.getHSSFWorkbook(sheetName, title, lists);

        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            workbook.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
