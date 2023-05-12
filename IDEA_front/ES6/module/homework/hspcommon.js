
let cat = {
    name: "hsp",
    age: 18,
    cry() {
        console.log("cry()")
    }
}

let dog = {
    name: "dog",
    age: 20,
    hi() {
        console.log("hi()")
    }
}

// 批量导出
export {
    cat,
    dog
}