package cn.edu.nju.segment;

import cn.edu.nju.dict.Dict;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by njucjc at 2018/10/5
 */
public class FBSegment implements  Segment {
    Dict dict;

    FMMSegment fmmSegment;

    BMMSegment bmmSegment;

    public FBSegment(Dict dict) {
        this.dict = dict;
        this.fmmSegment = new FMMSegment(dict);
        this.bmmSegment = new BMMSegment(dict);
    }

    public List<String> segment(String phrase) {
        List<String> fmmRes = fmmSegment.segment(phrase);
        List<String> bmmRes = bmmSegment.segment(phrase);

        if(fmmRes.size() != bmmRes.size()) {
            if(fmmRes.size() > bmmRes.size()) {
                return bmmRes;
            }
            else {
                return fmmRes;
            }
        }
        else {
            int fSingle = 0, bSingle = 0;
            boolean same = true;
            for(int i = 0; i < fmmRes.size(); i++) {
                if (!fmmRes.get(i).equals(bmmRes.get(i))) {
                    same = false;
                }

                if (fmmRes.get(i).length() == 1) {
                    fSingle++;
                }

                if (bmmRes.get(i).length() == 1) {
                    bSingle++;
                }
            }

            if(same) {
                return fmmRes;
            }
            else {
                if(bSingle > fSingle) {
                    return fmmRes;
                }
                else {
                    return bmmRes;
                }
            }
        }
    }
}
