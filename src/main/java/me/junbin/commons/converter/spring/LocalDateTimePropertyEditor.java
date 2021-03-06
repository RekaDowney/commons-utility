package me.junbin.commons.converter.spring;

import me.junbin.commons.util.Args;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : Zhong Junbin
 * @email : <a href="mailto:rekadowney@163.com">发送邮件</a>
 * @createDate : 2016-09-09 9:34
 * @description :
 */
public class LocalDateTimePropertyEditor extends PropertyEditorSupport {

    private final DateTimeFormatter formatter;

    public LocalDateTimePropertyEditor(DateTimeFormatter formatter) {
        this.formatter = Args.notNull(formatter);
    }

    public LocalDateTimePropertyEditor(final String pattern) {
        String notNullPattern = Args.notNull(pattern);
        this.formatter = DateTimeFormatter.ofPattern(notNullPattern.trim());
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(LocalDateTime.parse(text.trim(), formatter));
    }

}
