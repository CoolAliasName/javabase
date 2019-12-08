package com.heyh.valid.designpattern.duty.pipeline;

/**
 * 管道实现类
 */
public class StandarPipeline implements Pipeline {

    public Valve first = null;  // 管道中的第一个阀门
    public Valve basic = null;  // 管道中最后一个阀门

    @Override
    public Valve getFirst() {
        if (this.first != null) {
            return this.first;
        }
        return this.basic;
    }

    @Override
    public Valve getBasic() {
        return this.basic;
    }

    @Override
    public void setBasic(Valve valve) {
        Valve oldBasic = this.basic;
        Valve current = this.first;

        if (valve == oldBasic) {
            return;
        }
        if (valve == null) {
            return;
        }

        while (current != null) {
            // 找到最后一个阀门的前一个
            if (current.getNext() == oldBasic) {
                current.setNext(valve);
                break;
            }
            current = current.getNext();
        }
        this.basic = valve;
    }

    @Override
    public void addValve(Valve valve) {
        if (first == null) {
            this.first = valve;
            valve.setNext(basic);
        } else {
            Valve current = this.first;
            while (current != null) {
                // 找到倒数第二个阀门，将新添加阀门插入到倒数第二与倒数第一个阀门中
                if (current.getNext() == basic) {
                    current.setNext(valve);
                    valve.setNext(basic);
                    break;
                }
                current = current.getNext();
            }
        }
    }
}