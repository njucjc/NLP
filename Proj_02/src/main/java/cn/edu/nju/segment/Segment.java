package cn.edu.nju.segment;

import java.util.List;

/**
 * Created by njucjc at 2018/10/5
 */
public interface Segment {
    int MAX_LEN = 8;
    List<String> segment(String phrase);
}
