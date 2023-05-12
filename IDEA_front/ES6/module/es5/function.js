// 定义一些对象，变量，函数

const sum = function (a, b) {
    return parseInt(a) + parseInt(b);
}
const sub = function (a, b) {
    return parseInt(a) - parseInt(b);
}

let name = "韩顺平教育";

const PI = 3.14;

const monster = {
    name: "牛魔王",
    age: 200
}

// 导出
/*
    老韩解读
    1. module.exports 导入模块
    2. 把你需要导出的数据, 写到 {}之中
    3. 可以全部导出也可以部分导出
    4. 理解: 相当于把我们导出的数据当做一个对象
    5. 可以简写, 直接不写对象的名字
    6.  这里还可以简写为 module.exports = {} => exports = {}
 */
// module.exports = {
//     sum: sum,
//     sub: sub,
//     myname: name
// }


exports = {
    sum,
    sub,
    name,
    PI
}