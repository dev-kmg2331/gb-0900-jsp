const div = document.querySelector("div.banner");
const arrows = document.querySelectorAll("div.arrow");
const btns = document.querySelectorAll(".btn");
const firstDiv = document.createElement("div");
const lastDiv = document.createElement("div");
var count = 0;
var buttonCheck = true;
var numberButtonCheck = true;

firstDiv.innerHTML = `<img src="img/006.png">`;
div.insertBefore(firstDiv, document.querySelector("div.banner div"));

lastDiv.innerHTML = `<img src="img/001.png">`;
div.appendChild(lastDiv);

div.style.transform = "translate(-90vw)";

let inter = setInterval(autoSlide, 2500);

// function autoSlide(){
//     count ++;
//     if(count == 6){
//         count = 0;
//     }
//     div.style.transform = "translate(-" + 90 * count +"vw)"
//     div.style.transition = "transform 0.5s";
// }

function autoSlide() {
    div.style.transition = "transform 0.5s";
    count++;
    if (count == 6) { // 마지막 배너(6번)
        div.style.transform = "translate(-" + 90 * (count + 1) + "vw)"
        count = 0;
        setTimeout(function () {
            div.style.transition = "transform 0s";
            div.style.transform = "translate(-90vw)";
        }, 500);
    } else {
        div.style.transition = "transform 0.5s";
        div.style.transform = "translate(-" + 90 * (count + 1) + "vw)"
    }
}

// 이전버튼, 다음버튼
arrows.forEach(arrow => {
    arrow.addEventListener("click", function () {
        if (buttonCheck) {
            buttonCheck = false;
            let arrowType = arrow.classList[1];
            clearInterval(inter);
            div.style.transition = "transform 0.5s";
            if (arrowType == "prev") {
                count--;
                if (count == -1) {
                    div.style.transform = "translate(0vw)";
                    setTimeout(function () {
                        div.style.transition = "transform 0s";
                        div.style.transform = "translate(-540vw)";
                    }, 500);
                    count = 5;
                } else {
                    div.style.transform = "translate(-" + 90 * (count + 1) + "vw)";
                }

            } else {
                count++;
                if (count == 6) {
                    div.style.transform = "translate(-" + 90 * (count + 1) + "vw)";
                    setTimeout(function () {
                        div.style.transition = "transform 0s";
                        div.style.transform = "translate(-90vw)";
                    }, 500);
                    count = 0;
                } else {
                    div.style.transform = "translate(-" + 90 * (count + 1) + "vw)";
                }
            }

            inter = setInterval(autoSlide, 2500);

            setTimeout(() => { buttonCheck = true }, 500);
        }
    });
});
// arrows.forEach(arrow => {
//     arrow.addEventListener("click", function(){
//         let arrowType = arrow.classList[1];
//         if(arrowType == "prev"){
//             count --;
//             if(count == -1){
//                 count = 5;
//             }

//         }else{
//             count ++;
//             if(count == 6){
//                 count = 0;
//             }
//         }

//         div.style.transform = "translate(-" + 90 * count +"vw)"

//     });
// });

// 원하는 번호의 배너로 이동
// btns.forEach((btn, i) => {
//     btn.addEventListener("click", function(){
//         count = i;
//         div.style.transform = "translate(-" + 90 * count +"vw)"
//     });
// });

btns.forEach((btn, i) => {
    btn.addEventListener("click", function () {
        div.style.transition = "transform 0.5s";
        if (numberButtonCheck) {
            numberButtonCheck = false;
            clearInterval(inter);
            count = i;
            div.style.transform = "translate(-" + 90 * (count + 1) + "vw)"

            inter = setInterval(autoSlide, 2500);
            setTimeout(() => { numberButtonCheck = true }, 500);
        }
    });
});

