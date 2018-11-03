package com.keduox.reduce;

import com.keduox.pojo.OrderResultWritable;
import com.keduox.pojo.OrderWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class OrderReduce extends Reducer<Text,OrderWritable,Text,OrderResultWritable> {

    @Override
    protected void reduce(Text key, Iterable<OrderWritable> values, Context context) throws IOException, InterruptedException {
        OrderResultWritable orw = new OrderResultWritable();

        for (OrderWritable ow:values){
            orw.setName(ow.getName());
            orw.setPrice(ow.getPrice());
            orw.setAmount(ow.getAmount());
            orw.setResult(ow.getPrice()*ow.getAmount());
        }

        context.write(key,orw);

    }
}
