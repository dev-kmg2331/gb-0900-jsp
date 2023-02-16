let imgArr = new Array(
    'https://image.ohou.se/i/bucketplace-v2-development/uploads/store/banners/store_home_banners/167515622792642420.png?gif=1&w=2560&q=100',
    'https://image.ohou.se/i/bucketplace-v2-development/uploads/store/banners/store_home_banners/167516015960824455.png?gif=1&w=2560&q=100',
    'https://image.ohou.se/i/bucketplace-v2-development/uploads/store/banners/store_home_banners/167515652600435978.png?gif=1&w=2560&q=100',
    'https://image.ohou.se/i/bucketplace-v2-development/uploads/store/banners/store_home_banners/167532742983221456.png?gif=1&w=2560&q=100',
    'https://image.ohou.se/i/bucketplace-v2-development/uploads/store/banners/store_home_banners/167481133010267751.jpg?gif=1&w=2560&q=100',
    'https://image.ohou.se/i/bucketplace-v2-development/uploads/store/banners/store_home_banners/167515685145470025.png?gif=1&w=2560&q=100'
);

let banner = $('div.banner');
let arrowLeft = $('.menu-list-left');
let arrowRight = $('.menu-list-right');
let imgsCount = imgArr.length;
let imgsIndex = 0;
let intevalTime = 2000;
let arrows = $('li.arrow');

function loadImgs() {
    let htmlLine;

    for (let i = 0; i < imgsCount; i++) {
        htmlLine = `<div><img src=${imgArr[i]}></div>`;
        banner.append(htmlLine);
    }

    banner.prepend(htmlLine);
    htmlLine = `<div><img src=${imgArr[0]}></div>`;
    banner.append(htmlLine);
}

banner.css('width', 100 * (imgsCount + 2) + 'vw');

loadImgs();

let interval = setInterval(autoSlide, intevalTime);

function autoSlide() {
    banner.css('transition', 'transform 0.5s');
    imgsIndex++;
    if (imgsIndex == imgsCount + 1) {
        console.log(imgsIndex);

        console.log('7번째');
        banner.css('transform', 'translate(-' + 100 * imgsIndex + 'vw)');

        setTimeout(() => {
            imgsIndex = 1;
            banner.css('transition', 'transform 0s');
            banner.css('transform', 'translate(-' + 100 * imgsIndex + 'vw)');
        }, 500);

        return;
    }

    banner.css('transform', 'translate(-' + 100 * imgsIndex + 'vw)');
}

// console.log(arrows);

// arrows.each((index, item) => {
//     let arrow = $(item);

//     arrow.on('click',
//         () => {
//             clearInterval(interval);

//             var direction =
//                 arrow.attr('class') == 'menu-list-left arrow' ? 100 : -100;

//             alert("클릭됨!");

//             // console.log(arrow.attr('class'));
//             // console.log(direction);
//             // console.log(banner);

//             // banner.css('transition', 'transform 0.5s');
//             // banner.css('transform', `translste(${direction + (-100 * (imgsIndex))}vw`);
//             // console.log(banner.css('transform'));
//             // console.log(`translste(${direction + (-100 * (imgsIndex))}vw)`);
//         }
//     );
// });

// let test = $('.menu-list-left');
// test.on('click', () => {
//     $(banner).css('transform', `translste(${-100 + (-100 * (imgsIndex))}vw`);
// });

// function slideBtn(arrow) {
//     console.log(arrow);
//     arrow.on('click',
//         () => {
//             // clearInterval(interval);

//             var direction =
//                 arrow.attr('class') == 'menu-list-left arrow' ? 100 : -100;

//             console.log(arrow.attr('class'));
//             console.log(direction);
//             console.log(banner);

//             // banner.css('transition', 'transform 0.5s');
//             banner.css('transform', `translste(${direction + (-100 * (imgsIndex))}vw`);
//             console.log(banner.css('transform'));
//             console.log(`translste(${direction + (-100 * (imgsIndex))}vw)`);
//         }
//     );
// }
