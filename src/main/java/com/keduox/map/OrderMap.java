package com.keduox.map;

import com.keduox.pojo.OrderWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class OrderMap extends Mapper<LongWritable,Text,Text,OrderWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] dataArray=value.toString().split("\t");
        //清洗数据，防脏写
        if (dataArray.length==4){
            //
            OrderWritable orderWritable=new OrderWritable();
            orderWritable.setName(dataArray[1]);
            orderWritable.setPrice(Integer.parseInt(dataArray[2]));
            orderWritable.setAmount(Integer.parseInt(dataArray[3]));
            context.write(new Text(dataArray[0]),orderWritable);
        }
    }
}
