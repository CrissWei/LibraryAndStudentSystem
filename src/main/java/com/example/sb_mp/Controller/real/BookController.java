package com.example.sb_mp.Controller.real;


import com.example.sb_mp.Controller.utils.Result;
import com.example.sb_mp.Entity.Book;
import com.example.sb_mp.Entity.Student;
import com.example.sb_mp.service.IBookService;
import com.example.sb_mp.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/***
 * @Date 2022/8/14
 * 使用Postman可以完全实现这些操作，我自己成功了
 *
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService service;

    /**
     * 查询是get请求
     * 成功查询全部结果
     * http://localhost/students
     */
  /*  @GetMapping
    public List<Student> getAll(){
        return service.list();
    }*/
    @GetMapping
    public Result getAll() {
        return new Result(true, service.list());
    }

    /**
     * 这个是post请求
     *
     * @RequestBody 是请求体参数
     * http://localhost/students
     * 使用json格式，post传入到数据库
     * {   "id":"66",
     * "name":"李丽",
     * "age":"24",
     * "sex":"女",
     * "address":"北京",
     * "math":"99",
     * "english":"98"
     * }
     */
    @PostMapping
    public Result<Book> save(@RequestBody Book book) throws Exception {
        // return service.save(student);之前没用Result的代码
        // 正常来说这个是可以的，这里是为了把添加成功or失败的消息写在后端而不是前端(也可以把code写在前端提示用户)
        return new Result<Book>(service.save(book));

        //故意手动模拟一个异常，看看页面是怎么展示的，果然是显示我手动添加的异常消息
        //if (book.getName().equals("123")) throw new Exception();

        /***
         * 上面的code是在web前端显示固定写死操作成功or失败，
         * 下面的code是在后端动态显示操作成功or失败，但是除了问题，所以还是用上面的
         */
        //boolean flag = service.save(book);
        //return new Result(flag,500,"服务器故障，请稍后再试！");我自己的，不太行
        //自己的，，不太行
     /*   if (flag){//flag==true
            return new Result(flag,"添加成功");
        }else {
            return new Result(flag,"添加失败");
        }*/
        //return new Result(flag, flag ? "添加成功" : "添加失败");//老师的3元运算，不太行


    }


    /**
     * {   //修改id为10 的数据
     * "id":"10",
     * "name":"李丽",
     * "age":"24",
     * "sex":"女",
     * "address":"北京",
     * "math":"99",
     * "english":"98"
     * }
     * <p>
     * 不行啊，这个update方法有问题呢，测试多次，除了第一次成功成功，后面都不行了
     * 改成put请求，成功了。
     * 但是为什么web页面的代码是get请求
     * axios.put("/books/"+this.formData).then((result)=>{.....}
     */
    @PutMapping
    public Result update(@RequestBody Book book) {
        //return service.updateStudent(student);
        return new Result(true, service.updateBook(book));
    }

    /**
     * deleteStudent方法是我自定义的
     *
     * @DeleteMapping 有必要了解一下
     * @PathVariable 是请求体参数
     */
    @DeleteMapping("{id}")
    public Result<Book> delete(@PathVariable Integer id) {
        //return service.deleteStudent(id);
        return new Result<Book>(service.deleteBook(id));
    }

    /**
     * 删除id是15的数据
     * http://localhost/books/15
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Result<Book> getByID(@PathVariable Integer id) {
        //return service.getById(id);
        return new Result<Book>(true, service.getById(id));
    }

    /**
     * 分页操作
     */
    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        //return service.getPage(currentPage,pageSize);
        return new Result(true, service.getPage(currentPage, pageSize));
    }
}
