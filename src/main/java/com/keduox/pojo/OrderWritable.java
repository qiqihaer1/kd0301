package com.keduox.pojo;


import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class OrderWritable implements Writable {

    private String name;//名称
    private int price;//单价
    private int amount;//数量

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {

        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderWritable{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(name);
        dataOutput.writeInt(price);
        dataOutput.writeInt(amount);


    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
       name = dataInput.readUTF();
        price=dataInput.readInt();
        amount=dataInput.readInt();
    }
}
