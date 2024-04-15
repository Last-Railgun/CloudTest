package com.test.cloud.apis;

import com.test.cloud.entities.TPayDTO;
import com.test.cloud.resp.ResultData;
import com.test.cloud.resp.ReturnCode;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class PayFeignApiFallBack implements PayFeignApi {
    @Override
    public ResultData<String> addPay(TPayDTO tPayDTO) {
        return null;
    }

    @Override
    public ResultData<TPayDTO> getById(Integer id) {
        return null;
    }

    @Override
    public ResultData<List<TPayDTO>> getAll() {
        return null;
    }

    @Override
    public String getInfo() {
        return "";
    }

    @Override
    public ResultData<String> getCir(Integer id) {
        return ResultData.fail(ReturnCode.RC500.getCode(), "服务不可用!");
    }

    @Override
    public ResultData<String> getRatelimit(Integer id) {
        return null;
    }

    @Override
    public ResultData<String> getMic(Integer id) {
        return null;
    }

    @Override
    public ResultData<String> getFilter(HttpServletRequest request) {
        return null;
    }
}
