package com.example.typeconverter.formatter;

import com.example.typeconverter.converter.IpPortToStringConverter;
import com.example.typeconverter.converter.StringToIpPortConverter;
import com.example.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.*;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionServiceTest() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        //converter
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        //formatter
        conversionService.addFormatter(new MyNumberFormatter());

        //use converter
        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));

        //use formatter
        String convert = conversionService.convert(1000, String.class);
        assertThat(convert).isEqualTo("1,000");
    }
}
