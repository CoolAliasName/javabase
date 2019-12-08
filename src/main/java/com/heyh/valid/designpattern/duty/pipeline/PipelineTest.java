package com.heyh.valid.designpattern.duty.pipeline;

public class PipelineTest {

    public static void main(String[] args) {
        Valve valve1 = new MyValve1();
        Valve valve2 = new MyValve2();
        Valve valve3 = new MyValve3();

        Pipeline pipeline = new StandarPipeline();
        pipeline.setBasic(valve3);
        pipeline.addValve(valve1);
        pipeline.addValve(valve2);

        // 这个测试用例实现的是，一个请求从第一个环节开始往下执行，直到责任链结束。
        pipeline.getFirst().invoke();
    }

}