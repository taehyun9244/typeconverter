package com.example.typeconverter.converter;

import com.example.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class IpPortToStringConverter implements Converter<IpPort, String> {

    @Override
    public String convert(IpPort source) {
        log.info("convert source = {}", source);
        //IpPort Object -> "127.0.0.1:8080"
        return source.getIp() + ":" + source.getPort();
    }
}
