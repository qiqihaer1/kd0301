package com.keduox.pojo;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class OrderResultWritable implements Writable {
    private String name;//名称
    private int price;//单价
    private int amount;//数量
    private int result;//总价

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return name +"\t"+ price + "\t"+ amount +"\t" + result +"\t";
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(name);
        dataOutput.writeInt(price);
        dataOutput.writeInt(amount);
        dataOutput.writeInt(result);


    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        name = dataInput.readUTF();
        price=dataInput.readInt();
        amount=dataInput.readInt();
        result=dataInput.readInt();
    }
}
