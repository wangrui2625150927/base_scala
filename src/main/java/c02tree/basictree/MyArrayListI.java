package main.java.c02tree.basictree;

import javax.naming.directory.SearchControls;

/**
 * ClassName MyArrayListI
 * Description
 *
 * @author WangRui
 * @date 2020/8/5
 * @time 9:25
 * @since JDK 1.8
 */
public interface MyArrayListI<T> {

    /*
     * @Description
     * @Author WangRui
     * @Date 2020/8/5 9:46
     * @Param [object]
     * @return void
     */
    void add(T object);
    /*
     * @Description
     * @Author WangRui
     * @Date 2020/8/5 9:44
     * @Param [object]
     * @return void
     */
    void del(T object);
    /*
     * @Description
     * @Author WangRui
     * @Date 2020/8/5 9:45
     * @Param [id, object]
     * @return void
     */
    void update(int id,T object);
    /*
     * @Description
     * @Author WangRui
     * @Date 2020/8/5 9:45
     * @Param [id]
     * @return void
     */
    Object search(int id);


}
