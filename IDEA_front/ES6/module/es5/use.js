

// 导入
// 1. 在es5中, 我们可以把导出的数据当做对象使用
const m = require("./function");


// 只要idea可以识别到变量/函数/常量
let sum = m.sum(10, 20);
console.log(sum);

let name = m.name;

let PI = m.PI;


