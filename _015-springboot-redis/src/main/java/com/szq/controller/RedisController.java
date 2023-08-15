package com.szq.controller;

import com.szq.vo.Student;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {

    /**
     * 注入RedisTemplate
     *
     * RedisTemplate 泛型
     * RedisTemplate<String,String>
     * RedisTemplate<Object,Object>
     * RedisTemplate
     *
     *
     * 注意：RedisTemplate对象的名称 redisTemplate
     */
    @Resource
    private RedisTemplate redisTemplate;


    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/redis/addstring")
    public String addToRedis(String name,String value){

        //操作Redis中string类型的数据，先获取ValueOperations对象
        ValueOperations valueOperations = redisTemplate.opsForValue();

        //添加数据到redis
        valueOperations.set("myname","lisi");
        return "向redis添加string类型的数据";
    }

    //从Redis获取数据
    @GetMapping("/redis/getk")
    public String getData(String k){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object v = valueOperations.get(k);
        return "key是"+k+"它的值是："+v;
    }

    @PostMapping("/redis/{k}/{v}")
    public String addStringKV(@PathVariable String k,@PathVariable String v){
        //使用StringRedisTemplate对象
        stringRedisTemplate.opsForValue().set(k,v);
        return "使用StringRedisTemplate对象";
    }

    @GetMapping("/redis/getstr/{k}")
    public String getStringValue(@PathVariable String k){
        String v = stringRedisTemplate.opsForValue().get(k);
        return "k的value:"+v;
    }

    //设置RedisTemplate序列化机制
    //可以设置key的序列化，可以设置value的序列化
    /**
     * 利用同时设置key和value序列化
     */
    @PostMapping("/redis/addstr")
    public String addString(String k,String v){
        //使用RedisTemplate
        //设置key 使用String的序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        //设置value的序列化
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        redisTemplate.opsForValue().set(k,v);

        return "定义RedisTemple对象的key，value的序列化";
    }

    /**
     * 使用JSON序列化，把java对象转换为json存储
     */
    @PostMapping("/redis/addjson")
    public String addJSon(){
        Student student = new Student();

        student.setId(1001);
        student.setName("zhangsan");
        student.setAge(20);

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //把值作为json序列化
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Student.class));

        redisTemplate.opsForValue().set("mystudent",student);

        return "json的序列化";
    }

    @PostMapping("/redis/getjson")
    public String getJSon(){

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //把值作为json序列化
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Student.class));

        Object obj = redisTemplate.opsForValue().get("mystudent");

        return "json的反序列化="+obj;
    }
}
