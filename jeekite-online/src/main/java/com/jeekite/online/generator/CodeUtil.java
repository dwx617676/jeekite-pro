package com.jeekite.online.generator;

import com.jeekite.common.result.Result;
import com.jeekite.common.result.StatusCode;
import com.jeekite.online.build.TemplateBuilder;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Api(value = "com.jeekite")
@RestController
@RequestMapping("/code")
@CrossOrigin
public class CodeUtil {
    @ApiOperation(value = "获取所有的表",notes = "获取所有的表")
    @PostMapping(value = "/findAllTable" )
    public Result<List<String>> findAll(){
       //获取连接
        List<String> list=null;
        try {
            list=new ArrayList<>();
            Connection conn = TemplateBuilder.getConn();
            DatabaseMetaData metaData = conn.getMetaData();
            //获取数据库类型：MySQL
            String databaseType = metaData.getDatabaseProductName();
            if("MySQL".equals(databaseType)){
                //获取数据库名称
                String databaseName = conn.getCatalog();
                //获取所有的表结构
                ResultSet tableResultSet = metaData.getTables(null, databaseName, "%", new String[]{"TABLE"});
                while (tableResultSet.next()){
                    String tableName=tableResultSet.getString("TABLE_NAME");
                    list.add(tableName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Result(true, StatusCode.OK,"查询成功",list);
    }
    @ApiOperation(value = "根据表名称生成相应的代码",notes = "根据表名称生成相应的代码",tags = {"CodeUtil"})
    @ApiImplicitParam(paramType = "path", name = "tableName", value = "表名", required = true, dataType = "String")
    @GetMapping(value = "/{tableName}" )
    public Result online(@PathVariable String tableName){
        //调用SysUserService实现根据主键删除
        TemplateBuilder.builder(tableName);
        return new Result(true,StatusCode.OK,"生成成功");
    }
}
