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


// export default {
//     cat,
//     dog
// }

export default {
    cat: {
        name: "hsp",
        age: 18,
        cry() {
            console.log("cry()")
        }
    },

    dog: {
        name: "dog",
        age: 20,
        hi() {
            console.log("hi()")
        }
    }
}