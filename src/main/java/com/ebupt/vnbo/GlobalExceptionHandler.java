package com.ebupt.vnbo;

import com.ebupt.vnbo.entity.enums.RespCode;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.exception.OperationalException;
import com.ebupt.vnbo.entity.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xujun on 2017/10/18.
 */
@ControllerAdvice(annotations=RestController.class)
public class GlobalExceptionHandler {
    private static final Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class.getName());
    @ExceptionHandler(value = ODL_IO_Exception.class)
    @ResponseBody
    public Result<String> errorHandler(HttpServletRequest request,ODL_IO_Exception e){
        Result<String> result=new Result<>();
        result.setStatus(RespCode.fail);
        result.setDescription(e.getMessage());
        logger.error(result.toString());
        return result;
    }
}
