package cn.acitrus.component.core;

import cn.acitrus.component.protocol.TaskExecutor;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/6/22
 **/
public abstract class AbstractFileOperatorTaskExecutor implements TaskExecutor {
    @Override
    public void execute() {
        // 文件路径
        String filePath = getFilePath();
        // 写入内容
        writeFile();
    }

    protected abstract void writeFile();

    protected abstract String getFilePath();
}
