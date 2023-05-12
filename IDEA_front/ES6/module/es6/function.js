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
    age: 200,
    hi() {
        console.log("hi, " + name);
    }
};


/*
    1. export就是导出模块
    2. 可以部分导出
 */
export {
    sum,
    name,
    monster
}


