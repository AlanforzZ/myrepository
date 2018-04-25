package cn.biz.student.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import com.alibaba.fastjson.JSON;

import cn.biz.student.dao.IStudentManagerDao;
import cn.biz.student.domain.PageBean;
import cn.biz.student.domain.Student;
import cn.biz.student.utils.JedisUtils;

@SuppressWarnings("all")
public class StudentManagerDaoImpl implements IStudentManagerDao {
    JedisUtils jedisUtil = JedisUtils.getInstance();
    JedisUtils.SortSet Sortset = jedisUtil.new SortSet();
    JedisUtils.Strings Strings = jedisUtil.new Strings();
    JedisUtils.Keys Keys = jedisUtil.new Keys();

    public Set<String> findStudentByPageBean(PageBean pageBean) {
        Set<String> zrevrange = Sortset.zrevrange("student_range", pageBean.getIndexNumber(),
                pageBean.getIndexNumber() + pageBean.getPageSize() - 1);
        return zrevrange;
    }

    @Override
    public Long findStudentTotalCount() {
        Long zcard = Sortset.zcard("student_range");
        return zcard;
    }

    @Override
    public Student findStudentById(String id) throws IllegalAccessException, InvocationTargetException {
        String string = Strings.get("student_" + id);
        Student s = JSON.parseObject(string, Student.class);
        return s;
    }

    @Override
    public void saveOrUpdate(String json, String id, Integer score) {
        Strings.set("student_" + id, json);
        Sortset.zadd("student_range", score, id);
    }

    @Override
    public void deleteById(String id) {
        Keys.del("student_" + id);
        Sortset.zrem("student_range", id);
    }

}
