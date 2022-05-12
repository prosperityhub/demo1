import org.apache.jmeter.config.Argument;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;


public class Huhao extends AbstractJavaSamplerClient {

    //获取页面参数
    public Arguments getDefaultParameters() {
        Arguments arguments =  new Arguments();
        arguments.addArgument("name","HuHao");
        arguments.addArgument("ip","192.168.1.1");
        arguments.addArgument("post","8080");
        return arguments;
    }

    //初始化
    public void setupTest(JavaSamplerContext context) {
    }

    //迭代运行
    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        SampleResult result = new SampleResult();
        result.sampleStart();
        result.setSuccessful(true);
        result.setSampleLabel("test001");
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String name = context.getParameter("name");
        System.out.println(name+"：执行成功！");
        result.setResponseData(name.getBytes(StandardCharsets.UTF_8));
        result.sampleEnd();
        return result;
    }

    //运行结束
    public void teardownTest(JavaSamplerContext context) {
    }

    public static void main(String[] args) {
        Huhao huhao = new Huhao();
        JavaSamplerContext context = new JavaSamplerContext(huhao.getDefaultParameters());
        huhao.runTest(context);
    }
}
