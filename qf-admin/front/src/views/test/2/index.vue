<template>
    <div style="background-color: white">
        <div>
            <div
                v-for="(item, index) in dataList"
                style="display: flex; flex-direction: row"
            >
                <div style="width: 140px">
                    <span style="width: 100px">{{ item }}</span>
                    <svg-icon :icon-class="item" />
                </div>
                <div v-show="index % 5 == 0 && index != 0">
                    <br />
                </div>
            </div>
        </div>
        <div>
            <ul class="demo-icon-list" data-v-ea893728="">
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M480 480V128a32 32 0 0 1 64 0v352h352a32 32 0 1 1 0 64H544v352a32 32 0 1 1-64 0V544H128a32 32 0 0 1 0-64z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Plus</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M128 544h768a32 32 0 1 0 0-64H128a32 32 0 0 0 0 64"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Minus</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M352 480h320a32 32 0 1 1 0 64H352a32 32 0 0 1 0-64"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M480 672V352a32 32 0 1 1 64 0v320a32 32 0 0 1-64 0"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M512 896a384 384 0 1 0 0-768 384 384 0 0 0 0 768m0 64a448 448 0 1 1 0-896 448 448 0 0 1 0 896"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >CirclePlus</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="m795.904 750.72 124.992 124.928a32 32 0 0 1-45.248 45.248L750.656 795.904a416 416 0 1 1 45.248-45.248zM480 832a352 352 0 1 0 0-704 352 352 0 0 0 0 704"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Search</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 640a256 256 0 1 0 0-512 256 256 0 0 0 0 512m0 64a320 320 0 1 1 0-640 320 320 0 0 1 0 640"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M512 640q32 0 32 32v256q0 32-32 32t-32-32V672q0-32 32-32"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M352 800h320q32 0 32 32t-32 32H352q-32 0-32-32t32-32"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Female</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M399.5 849.5a225 225 0 1 0 0-450 225 225 0 0 0 0 450m0 56.25a281.25 281.25 0 1 1 0-562.5 281.25 281.25 0 0 1 0 562.5m253.125-787.5h225q28.125 0 28.125 28.125T877.625 174.5h-225q-28.125 0-28.125-28.125t28.125-28.125"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M877.625 118.25q28.125 0 28.125 28.125v225q0 28.125-28.125 28.125T849.5 371.375v-225q0-28.125 28.125-28.125"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M604.813 458.9 565.1 419.131l292.613-292.668 39.825 39.824z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Male</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 896a384 384 0 1 0 0-768 384 384 0 0 0 0 768m0 64a448 448 0 1 1 0-896 448 448 0 0 1 0 896"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M512 96a32 32 0 0 1 32 32v192a32 32 0 0 1-64 0V128a32 32 0 0 1 32-32m0 576a32 32 0 0 1 32 32v192a32 32 0 1 1-64 0V704a32 32 0 0 1 32-32M96 512a32 32 0 0 1 32-32h192a32 32 0 0 1 0 64H128a32 32 0 0 1-32-32m576 0a32 32 0 0 1 32-32h192a32 32 0 1 1 0 64H704a32 32 0 0 1-32-32"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Aim</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M192 413.952V896h640V413.952L512 147.328zM139.52 374.4l352-293.312a32 32 0 0 1 40.96 0l352 293.312A32 32 0 0 1 896 398.976V928a32 32 0 0 1-32 32H160a32 32 0 0 1-32-32V398.976a32 32 0 0 1 11.52-24.576"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >House</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="m160 96.064 192 .192a32 32 0 0 1 0 64l-192-.192V352a32 32 0 0 1-64 0V96h64zm0 831.872V928H96V672a32 32 0 1 1 64 0v191.936l192-.192a32 32 0 1 1 0 64zM864 96.064V96h64v256a32 32 0 1 1-64 0V160.064l-192 .192a32 32 0 1 1 0-64l192-.192zm0 831.872-192-.192a32 32 0 0 1 0-64l192 .192V672a32 32 0 1 1 64 0v256h-64z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >FullScreen</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 64a32 32 0 0 1 32 32v192a32 32 0 0 1-64 0V96a32 32 0 0 1 32-32m0 640a32 32 0 0 1 32 32v192a32 32 0 1 1-64 0V736a32 32 0 0 1 32-32m448-192a32 32 0 0 1-32 32H736a32 32 0 1 1 0-64h192a32 32 0 0 1 32 32m-640 0a32 32 0 0 1-32 32H96a32 32 0 0 1 0-64h192a32 32 0 0 1 32 32M195.2 195.2a32 32 0 0 1 45.248 0L376.32 331.008a32 32 0 0 1-45.248 45.248L195.2 240.448a32 32 0 0 1 0-45.248zm452.544 452.544a32 32 0 0 1 45.248 0L828.8 783.552a32 32 0 0 1-45.248 45.248L647.744 692.992a32 32 0 0 1 0-45.248zM828.8 195.264a32 32 0 0 1 0 45.184L692.992 376.32a32 32 0 0 1-45.248-45.248l135.808-135.808a32 32 0 0 1 45.248 0m-452.544 452.48a32 32 0 0 1 0 45.248L240.448 828.8a32 32 0 0 1-45.248-45.248l135.808-135.808a32 32 0 0 1 45.248 0z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Loading</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M715.648 625.152 670.4 579.904l90.496-90.56c75.008-74.944 85.12-186.368 22.656-248.896-62.528-62.464-173.952-52.352-248.96 22.656L444.16 353.6l-45.248-45.248 90.496-90.496c100.032-99.968 251.968-110.08 339.456-22.656 87.488 87.488 77.312 239.424-22.656 339.456l-90.496 90.496zm-90.496 90.496-90.496 90.496C434.624 906.112 282.688 916.224 195.2 828.8c-87.488-87.488-77.312-239.424 22.656-339.456l90.496-90.496 45.248 45.248-90.496 90.56c-75.008 74.944-85.12 186.368-22.656 248.896 62.528 62.464 173.952 52.352 248.96-22.656l90.496-90.496zm0-362.048 45.248 45.248L398.848 670.4 353.6 625.152z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Link</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M864 409.6a192 192 0 0 1-37.888 349.44A256.064 256.064 0 0 1 576 960h-96a32 32 0 1 1 0-64h96a192.064 192.064 0 0 0 181.12-128H736a32 32 0 0 1-32-32V416a32 32 0 0 1 32-32h32c10.368 0 20.544.832 30.528 2.432a288 288 0 0 0-573.056 0A193.235 193.235 0 0 1 256 384h32a32 32 0 0 1 32 32v320a32 32 0 0 1-32 32h-32a192 192 0 0 1-96-358.4 352 352 0 0 1 704 0M256 448a128 128 0 1 0 0 256zm640 128a128 128 0 0 0-128-128v256a128 128 0 0 0 128-128"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Service</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M511.552 128c-35.584 0-64.384 28.8-64.384 64.448v516.48L274.048 570.88a94.272 94.272 0 0 0-112.896-3.456 44.416 44.416 0 0 0-8.96 62.208L332.8 870.4A64 64 0 0 0 384 896h512V575.232a64 64 0 0 0-45.632-61.312l-205.952-61.76A96 96 0 0 1 576 360.192V192.448C576 156.8 547.2 128 511.552 128M359.04 556.8l24.128 19.2V192.448a128.448 128.448 0 1 1 256.832 0v167.744a32 32 0 0 0 22.784 30.656l206.016 61.76A128 128 0 0 1 960 575.232V896a64 64 0 0 1-64 64H384a128 128 0 0 1-102.4-51.2L101.056 668.032A108.416 108.416 0 0 1 128 512.512a158.272 158.272 0 0 1 185.984 8.32z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Pointer</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="m512 747.84 228.16 119.936a6.4 6.4 0 0 0 9.28-6.72l-43.52-254.08 184.512-179.904a6.4 6.4 0 0 0-3.52-10.88l-255.104-37.12L517.76 147.904a6.4 6.4 0 0 0-11.52 0L392.192 379.072l-255.104 37.12a6.4 6.4 0 0 0-3.52 10.88L318.08 606.976l-43.584 254.08a6.4 6.4 0 0 0 9.28 6.72zM313.6 924.48a70.4 70.4 0 0 1-102.144-74.24l37.888-220.928L88.96 472.96A70.4 70.4 0 0 1 128 352.896l221.76-32.256 99.2-200.96a70.4 70.4 0 0 1 126.208 0l99.2 200.96 221.824 32.256a70.4 70.4 0 0 1 39.04 120.064L774.72 629.376l37.888 220.928a70.4 70.4 0 0 1-102.144 74.24L512 820.096l-198.4 104.32z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Star</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 128v64H256a64 64 0 0 0-64 64v512a64 64 0 0 0 64 64h512a64 64 0 0 0 64-64V512h64v256a128 128 0 0 1-128 128H256a128 128 0 0 1-128-128V256a128 128 0 0 1 128-128z"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M768 384a128 128 0 1 0 0-256 128 128 0 0 0 0 256m0 64a192 192 0 1 1 0-384 192 192 0 0 1 0 384"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Notification</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M640 384v64H448a128 128 0 0 0-128 128v128a128 128 0 0 0 128 128h320a128 128 0 0 0 128-128V576a128 128 0 0 0-64-110.848V394.88c74.56 26.368 128 97.472 128 181.056v128a192 192 0 0 1-192 192H448a192 192 0 0 1-192-192V576a192 192 0 0 1 192-192z"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M384 640v-64h192a128 128 0 0 0 128-128V320a128 128 0 0 0-128-128H256a128 128 0 0 0-128 128v128a128 128 0 0 0 64 110.848v70.272A192.064 192.064 0 0 1 64 448V320a192 192 0 0 1 192-192h320a192 192 0 0 1 192 192v128a192 192 0 0 1-192 192z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Connection</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="m174.72 855.68 135.296-45.12 23.68 11.84C388.096 849.536 448.576 864 512 864c211.84 0 384-166.784 384-352S723.84 160 512 160 128 326.784 128 512c0 69.12 24.96 139.264 70.848 199.232l22.08 28.8-46.272 115.584zm-45.248 82.56A32 32 0 0 1 89.6 896l58.368-145.92C94.72 680.32 64 596.864 64 512 64 299.904 256 96 512 96s448 203.904 448 416-192 416-448 416a461.056 461.056 0 0 1-206.912-48.384l-175.616 58.56z"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M512 563.2a51.2 51.2 0 1 1 0-102.4 51.2 51.2 0 0 1 0 102.4m192 0a51.2 51.2 0 1 1 0-102.4 51.2 51.2 0 0 1 0 102.4m-384 0a51.2 51.2 0 1 1 0-102.4 51.2 51.2 0 0 1 0 102.4"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >ChatDotRound</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M600.704 64a32 32 0 0 1 30.464 22.208l35.2 109.376c14.784 7.232 28.928 15.36 42.432 24.512l112.384-24.192a32 32 0 0 1 34.432 15.36L944.32 364.8a32 32 0 0 1-4.032 37.504l-77.12 85.12a357.12 357.12 0 0 1 0 49.024l77.12 85.248a32 32 0 0 1 4.032 37.504l-88.704 153.6a32 32 0 0 1-34.432 15.296L708.8 803.904c-13.44 9.088-27.648 17.28-42.368 24.512l-35.264 109.376A32 32 0 0 1 600.704 960H423.296a32 32 0 0 1-30.464-22.208L357.696 828.48a351.616 351.616 0 0 1-42.56-24.64l-112.32 24.256a32 32 0 0 1-34.432-15.36L79.68 659.2a32 32 0 0 1 4.032-37.504l77.12-85.248a357.12 357.12 0 0 1 0-48.896l-77.12-85.248A32 32 0 0 1 79.68 364.8l88.704-153.6a32 32 0 0 1 34.432-15.296l112.32 24.256c13.568-9.152 27.776-17.408 42.56-24.64l35.2-109.312A32 32 0 0 1 423.232 64H600.64zm-23.424 64H446.72l-36.352 113.088-24.512 11.968a294.113 294.113 0 0 0-34.816 20.096l-22.656 15.36-116.224-25.088-65.28 113.152 79.68 88.192-1.92 27.136a293.12 293.12 0 0 0 0 40.192l1.92 27.136-79.808 88.192 65.344 113.152 116.224-25.024 22.656 15.296a294.113 294.113 0 0 0 34.816 20.096l24.512 11.968L446.72 896h130.688l36.48-113.152 24.448-11.904a288.282 288.282 0 0 0 34.752-20.096l22.592-15.296 116.288 25.024 65.28-113.152-79.744-88.192 1.92-27.136a293.12 293.12 0 0 0 0-40.256l-1.92-27.136 79.808-88.128-65.344-113.152-116.288 24.96-22.592-15.232a287.616 287.616 0 0 0-34.752-20.096l-24.448-11.904L577.344 128zM512 320a192 192 0 1 1 0 384 192 192 0 0 1 0-384m0 64a128 128 0 1 0 0 256 128 128 0 0 0 0-256"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Setting</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 896a384 384 0 1 0 0-768 384 384 0 0 0 0 768m0 64a448 448 0 1 1 0-896 448 448 0 0 1 0 896"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M480 256a32 32 0 0 1 32 32v256a32 32 0 0 1-64 0V288a32 32 0 0 1 32-32"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M480 512h256q32 0 32 32t-32 32H480q-32 0-32-32t32-32"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Clock</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="m249.6 417.088 319.744 43.072 39.168 310.272L845.12 178.88 249.6 417.088zm-129.024 47.168a32 32 0 0 1-7.68-61.44l777.792-311.04a32 32 0 0 1 41.6 41.6l-310.336 775.68a32 32 0 0 1-61.44-7.808L512 516.992l-391.424-52.736z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Position</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M224 704h576V318.336L552.512 115.84a64 64 0 0 0-81.024 0L224 318.336zm0 64v128h576V768zM593.024 66.304l259.2 212.096A32 32 0 0 1 864 303.168V928a32 32 0 0 1-32 32H192a32 32 0 0 1-32-32V303.168a32 32 0 0 1 11.712-24.768l259.2-212.096a128 128 0 0 1 162.112 0"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M512 448a64 64 0 1 0 0-128 64 64 0 0 0 0 128m0 64a128 128 0 1 1 0-256 128 128 0 0 1 0 256"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Discount</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 896a384 384 0 1 0 0-768 384 384 0 0 0 0 768m0 64a448 448 0 1 1 0-896 448 448 0 0 1 0 896"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M192 512a320 320 0 1 1 640 0 32 32 0 1 1-64 0 256 256 0 1 0-512 0 32 32 0 0 1-64 0"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M570.432 627.84A96 96 0 1 1 509.568 608l60.992-187.776A32 32 0 1 1 631.424 440l-60.992 187.776zM502.08 734.464a32 32 0 1 0 19.84-60.928 32 32 0 0 0-19.84 60.928"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Odometer</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M273.536 736H800a64 64 0 0 0 64-64V256a64 64 0 0 0-64-64H224a64 64 0 0 0-64 64v570.88zM296 800 147.968 918.4A32 32 0 0 1 96 893.44V256a128 128 0 0 1 128-128h576a128 128 0 0 1 128 128v416a128 128 0 0 1-128 128z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >ChatSquare</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="m174.72 855.68 130.048-43.392 23.424 11.392C382.4 849.984 444.352 864 512 864c223.744 0 384-159.872 384-352 0-192.832-159.104-352-384-352S128 319.168 128 512a341.12 341.12 0 0 0 69.248 204.288l21.632 28.8-44.16 110.528zm-45.248 82.56A32 32 0 0 1 89.6 896l56.512-141.248A405.12 405.12 0 0 1 64 512C64 299.904 235.648 96 512 96s448 203.904 448 416-173.44 416-448 416c-79.68 0-150.848-17.152-211.712-46.72l-170.88 56.96z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >ChatRound</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="m174.72 855.68 135.296-45.12 23.68 11.84C388.096 849.536 448.576 864 512 864c211.84 0 384-166.784 384-352S723.84 160 512 160 128 326.784 128 512c0 69.12 24.96 139.264 70.848 199.232l22.08 28.8-46.272 115.584zm-45.248 82.56A32 32 0 0 1 89.6 896l58.368-145.92C94.72 680.32 64 596.864 64 512 64 299.904 256 96 512 96s448 203.904 448 416-192 416-448 416a461.056 461.056 0 0 1-206.912-48.384l-175.616 58.56z"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M352 576h320q32 0 32 32t-32 32H352q-32 0-32-32t32-32m32-192h256q32 0 32 32t-32 32H384q-32 0-32-32t32-32"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >ChatLineRound</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M160 826.88 273.536 736H800a64 64 0 0 0 64-64V256a64 64 0 0 0-64-64H224a64 64 0 0 0-64 64zM296 800 147.968 918.4A32 32 0 0 1 96 893.44V256a128 128 0 0 1 128-128h576a128 128 0 0 1 128 128v416a128 128 0 0 1-128 128z"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M352 512h320q32 0 32 32t-32 32H352q-32 0-32-32t32-32m0-192h320q32 0 32 32t-32 32H352q-32 0-32-32t32-32"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >ChatLineSquare</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M273.536 736H800a64 64 0 0 0 64-64V256a64 64 0 0 0-64-64H224a64 64 0 0 0-64 64v570.88zM296 800 147.968 918.4A32 32 0 0 1 96 893.44V256a128 128 0 0 1 128-128h576a128 128 0 0 1 128 128v416a128 128 0 0 1-128 128z"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M512 499.2a51.2 51.2 0 1 1 0-102.4 51.2 51.2 0 0 1 0 102.4zm192 0a51.2 51.2 0 1 1 0-102.4 51.2 51.2 0 0 1 0 102.4zm-384 0a51.2 51.2 0 1 1 0-102.4 51.2 51.2 0 0 1 0 102.4z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >ChatDotSquare</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 160c320 0 512 352 512 352S832 864 512 864 0 512 0 512s192-352 512-352m0 64c-225.28 0-384.128 208.064-436.8 288 52.608 79.872 211.456 288 436.8 288 225.28 0 384.128-208.064 436.8-288-52.608-79.872-211.456-288-436.8-288zm0 64a224 224 0 1 1 0 448 224 224 0 0 1 0-448m0 64a160.192 160.192 0 0 0-160 160c0 88.192 71.744 160 160 160s160-71.808 160-160-71.744-160-160-160"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >View</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M876.8 156.8c0-9.6-3.2-16-9.6-22.4-6.4-6.4-12.8-9.6-22.4-9.6-9.6 0-16 3.2-22.4 9.6L736 220.8c-64-32-137.6-51.2-224-60.8-160 16-288 73.6-377.6 176C44.8 438.4 0 496 0 512s48 73.6 134.4 176c22.4 25.6 44.8 48 73.6 67.2l-86.4 89.6c-6.4 6.4-9.6 12.8-9.6 22.4 0 9.6 3.2 16 9.6 22.4 6.4 6.4 12.8 9.6 22.4 9.6 9.6 0 16-3.2 22.4-9.6l704-710.4c3.2-6.4 6.4-12.8 6.4-22.4Zm-646.4 528c-76.8-70.4-128-128-153.6-172.8 28.8-48 80-105.6 153.6-172.8C304 272 400 230.4 512 224c64 3.2 124.8 19.2 176 44.8l-54.4 54.4C598.4 300.8 560 288 512 288c-64 0-115.2 22.4-160 64s-64 96-64 160c0 48 12.8 89.6 35.2 124.8L256 707.2c-9.6-6.4-19.2-16-25.6-22.4Zm140.8-96c-12.8-22.4-19.2-48-19.2-76.8 0-44.8 16-83.2 48-112 32-28.8 67.2-48 112-48 28.8 0 54.4 6.4 73.6 19.2zM889.599 336c-12.8-16-28.8-28.8-41.6-41.6l-48 48c73.6 67.2 124.8 124.8 150.4 169.6-28.8 48-80 105.6-153.6 172.8-73.6 67.2-172.8 108.8-284.8 115.2-51.2-3.2-99.2-12.8-140.8-28.8l-48 48c57.6 22.4 118.4 38.4 188.8 44.8 160-16 288-73.6 377.6-176C979.199 585.6 1024 528 1024 512s-48.001-73.6-134.401-176Z"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M511.998 672c-12.8 0-25.6-3.2-38.4-6.4l-51.2 51.2c28.8 12.8 57.6 19.2 89.6 19.2 64 0 115.2-22.4 160-64 41.6-41.6 64-96 64-160 0-32-6.4-64-19.2-89.6l-51.2 51.2c3.2 12.8 6.4 25.6 6.4 38.4 0 44.8-16 83.2-48 112-32 28.8-67.2 48-112 48Z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Hide</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M224 448a32 32 0 0 0-32 32v384a32 32 0 0 0 32 32h576a32 32 0 0 0 32-32V480a32 32 0 0 0-32-32zm0-64h576a96 96 0 0 1 96 96v384a96 96 0 0 1-96 96H224a96 96 0 0 1-96-96V480a96 96 0 0 1 96-96"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M512 544a32 32 0 0 1 32 32v192a32 32 0 1 1-64 0V576a32 32 0 0 1 32-32m178.304-295.296A192.064 192.064 0 0 0 320 320v64h352l96 38.4V448H256V320a256 256 0 0 1 493.76-95.104z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Unlock</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M224 448a32 32 0 0 0-32 32v384a32 32 0 0 0 32 32h576a32 32 0 0 0 32-32V480a32 32 0 0 0-32-32zm0-64h576a96 96 0 0 1 96 96v384a96 96 0 0 1-96 96H224a96 96 0 0 1-96-96V480a96 96 0 0 1 96-96"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M512 544a32 32 0 0 1 32 32v192a32 32 0 1 1-64 0V576a32 32 0 0 1 32-32m192-160v-64a192 192 0 1 0-384 0v64zM512 64a256 256 0 0 1 256 256v128H256V320A256 256 0 0 1 512 64"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Lock</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M784.512 230.272v-50.56a32 32 0 1 1 64 0v149.056a32 32 0 0 1-32 32H667.52a32 32 0 1 1 0-64h92.992A320 320 0 1 0 524.8 833.152a320 320 0 0 0 320-320h64a384 384 0 0 1-384 384 384 384 0 0 1-384-384 384 384 0 0 1 643.712-282.88z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >RefreshRight</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M289.088 296.704h92.992a32 32 0 0 1 0 64H232.96a32 32 0 0 1-32-32V179.712a32 32 0 0 1 64 0v50.56a384 384 0 0 1 643.84 282.88 384 384 0 0 1-383.936 384 384 384 0 0 1-384-384h64a320 320 0 1 0 640 0 320 320 0 0 0-555.712-216.448z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >RefreshLeft</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M771.776 794.88A384 384 0 0 1 128 512h64a320 320 0 0 0 555.712 216.448H654.72a32 32 0 1 1 0-64h149.056a32 32 0 0 1 32 32v148.928a32 32 0 1 1-64 0v-50.56zM276.288 295.616h92.992a32 32 0 0 1 0 64H220.16a32 32 0 0 1-32-32V178.56a32 32 0 0 1 64 0v50.56A384 384 0 0 1 896.128 512h-64a320 320 0 0 0-555.776-216.384z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Refresh</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 64a64 64 0 0 1 64 64v64H448v-64a64 64 0 0 1 64-64"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M256 768h512V448a256 256 0 1 0-512 0zm256-640a320 320 0 0 1 320 320v384H192V448a320 320 0 0 1 320-320"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M96 768h832q32 0 32 32t-32 32H96q-32 0-32-32t32-32m352 128h128a64 64 0 0 1-128 0"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Bell</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="m241.216 832 63.616-64H768V448c0-42.368-10.24-82.304-28.48-117.504l46.912-47.232C815.36 331.392 832 387.84 832 448v320h96a32 32 0 1 1 0 64zm-90.24 0H96a32 32 0 1 1 0-64h96V448a320.128 320.128 0 0 1 256-313.6V128a64 64 0 1 1 128 0v6.4a319.552 319.552 0 0 1 171.648 97.088l-45.184 45.44A256 256 0 0 0 256 448v278.336L151.04 832zM448 896h128a64 64 0 0 1-128 0"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M150.72 859.072a32 32 0 0 1-45.44-45.056l704-708.544a32 32 0 0 1 45.44 45.056l-704 708.544z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >MuteNotification</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 512a192 192 0 1 0 0-384 192 192 0 0 0 0 384m0 64a256 256 0 1 1 0-512 256 256 0 0 1 0 512m320 320v-96a96 96 0 0 0-96-96H288a96 96 0 0 0-96 96v96a32 32 0 1 1-64 0v-96a160 160 0 0 1 160-160h448a160 160 0 0 1 160 160v96a32 32 0 1 1-64 0"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >User</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M406.656 706.944 195.84 496.256a32 32 0 1 0-45.248 45.248l256 256 512-512a32 32 0 0 0-45.248-45.248L406.592 706.944z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Check</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 896a384 384 0 1 0 0-768 384 384 0 0 0 0 768m0 64a448 448 0 1 1 0-896 448 448 0 0 1 0 896"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M745.344 361.344a32 32 0 0 1 45.312 45.312l-288 288a32 32 0 0 1-45.312 0l-160-160a32 32 0 1 1 45.312-45.312L480 626.752l265.344-265.408z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >CircleCheck</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 64a448 448 0 1 1 0 896 448 448 0 0 1 0-896m0 832a384 384 0 0 0 0-768 384 384 0 0 0 0 768m48-176a48 48 0 1 1-96 0 48 48 0 0 1 96 0m-48-464a32 32 0 0 1 32 32v288a32 32 0 0 1-64 0V288a32 32 0 0 1 32-32"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Warning</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="m466.752 512-90.496-90.496a32 32 0 0 1 45.248-45.248L512 466.752l90.496-90.496a32 32 0 1 1 45.248 45.248L557.248 512l90.496 90.496a32 32 0 1 1-45.248 45.248L512 557.248l-90.496 90.496a32 32 0 0 1-45.248-45.248z"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M512 896a384 384 0 1 0 0-768 384 384 0 0 0 0 768m0 64a448 448 0 1 1 0-896 448 448 0 0 1 0 896"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >CircleClose</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M764.288 214.592 512 466.88 259.712 214.592a31.936 31.936 0 0 0-45.12 45.12L466.752 512 214.528 764.224a31.936 31.936 0 1 0 45.12 45.184L512 557.184l252.288 252.288a31.936 31.936 0 0 0 45.12-45.12L557.12 512.064l252.288-252.352a31.936 31.936 0 1 0-45.12-45.184z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Close</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M448 68.48v64.832A384.128 384.128 0 0 0 512 896a384.128 384.128 0 0 0 378.688-320h64.768A448.128 448.128 0 0 1 64 512 448.128 448.128 0 0 1 448 68.48z"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M576 97.28V448h350.72A384.064 384.064 0 0 0 576 97.28zM512 64V33.152A448 448 0 0 1 990.848 512H512z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >PieChart</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M176 416a112 112 0 1 0 0 224 112 112 0 0 0 0-224m0 64a48 48 0 1 1 0 96 48 48 0 0 1 0-96m336-64a112 112 0 1 1 0 224 112 112 0 0 1 0-224m0 64a48 48 0 1 0 0 96 48 48 0 0 0 0-96m336-64a112 112 0 1 1 0 224 112 112 0 0 1 0-224m0 64a48 48 0 1 0 0 96 48 48 0 0 0 0-96"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >More</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 896a384 384 0 1 0 0-768 384 384 0 0 0 0 768m0 64a448 448 0 1 1 0-896 448 448 0 0 1 0 896"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M725.888 315.008C676.48 428.672 624 513.28 568.576 568.64c-55.424 55.424-139.968 107.904-253.568 157.312a12.8 12.8 0 0 1-16.896-16.832c49.536-113.728 102.016-198.272 157.312-253.632 55.36-55.296 139.904-107.776 253.632-157.312a12.8 12.8 0 0 1 16.832 16.832"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Compass</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M384 523.392V928a32 32 0 0 0 46.336 28.608l192-96A32 32 0 0 0 640 832V523.392l280.768-343.104a32 32 0 1 0-49.536-40.576l-288 352A32 32 0 0 0 576 512v300.224l-128 64V512a32 32 0 0 0-7.232-20.288L195.52 192H704a32 32 0 1 0 0-64H128a32 32 0 0 0-24.768 52.288z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Filter</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M118.656 438.656a32 32 0 0 1 0-45.248L416 96l4.48-3.776A32 32 0 0 1 461.248 96l3.712 4.48a32.064 32.064 0 0 1-3.712 40.832L218.56 384H928a32 32 0 1 1 0 64H141.248a32 32 0 0 1-22.592-9.344zM64 608a32 32 0 0 1 32-32h786.752a32 32 0 0 1 22.656 54.592L608 928l-4.48 3.776a32.064 32.064 0 0 1-40.832-49.024L805.632 640H96a32 32 0 0 1-32-32"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Switch</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M77.248 415.04a64 64 0 0 1 90.496 0l226.304 226.304L846.528 188.8a64 64 0 1 1 90.56 90.496l-543.04 543.04-316.8-316.8a64 64 0 0 1 0-90.496z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Select</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M128 448h768q64 0 64 64t-64 64H128q-64 0-64-64t64-64"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >SemiSelect</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M195.2 195.2a64 64 0 0 1 90.496 0L512 421.504 738.304 195.2a64 64 0 0 1 90.496 90.496L602.496 512 828.8 738.304a64 64 0 0 1-90.496 90.496L512 602.496 285.696 828.8a64 64 0 0 1-90.496-90.496L421.504 512 195.2 285.696a64 64 0 0 1 0-90.496z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >CloseBold</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="m199.04 672.64 193.984 112 224-387.968-193.92-112-224 388.032zm-23.872 60.16 32.896 148.288 144.896-45.696zM455.04 229.248l193.92 112 56.704-98.112-193.984-112-56.64 98.112zM104.32 708.8l384-665.024 304.768 175.936L409.152 884.8h.064l-248.448 78.336zm384 254.272v-64h448v64h-448z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >EditPen</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M832 512a32 32 0 1 1 64 0v352a32 32 0 0 1-32 32H160a32 32 0 0 1-32-32V160a32 32 0 0 1 32-32h352a32 32 0 0 1 0 64H192v640h640z"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="m469.952 554.24 52.8-7.552L847.104 222.4a32 32 0 1 0-45.248-45.248L477.44 501.44l-7.552 52.8zm422.4-422.4a96 96 0 0 1 0 135.808l-331.84 331.84a32 32 0 0 1-18.112 9.088L436.8 623.68a32 32 0 0 1-36.224-36.224l15.104-105.6a32 32 0 0 1 9.024-18.112l331.904-331.84a96 96 0 0 1 135.744 0z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Edit</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M128 224v512a64 64 0 0 0 64 64h640a64 64 0 0 0 64-64V224zm0-64h768a64 64 0 0 1 64 64v512a128 128 0 0 1-128 128H192A128 128 0 0 1 64 736V224a64 64 0 0 1 64-64"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M904 224 656.512 506.88a192 192 0 0 1-289.024 0L120 224zm-698.944 0 210.56 240.704a128 128 0 0 0 192.704 0L818.944 224H205.056"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Message</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M288 384h448v64H288zm96-128h256v64H384zM131.456 512H384v128h256V512h252.544L721.856 192H302.144zM896 576H704v128H320V576H128v256h768zM275.776 128h472.448a32 32 0 0 1 28.608 17.664l179.84 359.552A32 32 0 0 1 960 519.552V864a32 32 0 0 1-32 32H96a32 32 0 0 1-32-32V519.552a32 32 0 0 1 3.392-14.336l179.776-359.552A32 32 0 0 1 275.776 128z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >MessageBox</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M329.956 257.138a254.862 254.862 0 0 0 0 509.724h364.088a254.862 254.862 0 0 0 0-509.724zm0-72.818h364.088a327.68 327.68 0 1 1 0 655.36H329.956a327.68 327.68 0 1 1 0-655.36z"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M329.956 621.227a109.227 109.227 0 1 0 0-218.454 109.227 109.227 0 0 0 0 218.454m0 72.817a182.044 182.044 0 1 1 0-364.088 182.044 182.044 0 0 1 0 364.088"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >TurnOff</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M280.768 753.728 691.456 167.04a32 32 0 1 1 52.416 36.672L314.24 817.472a32 32 0 0 1-45.44 7.296l-230.4-172.8a32 32 0 0 1 38.4-51.2l203.968 152.96zM736 448a32 32 0 1 1 0-64h192a32 32 0 1 1 0 64zM608 640a32 32 0 0 1 0-64h319.936a32 32 0 1 1 0 64zM480 832a32 32 0 1 1 0-64h447.936a32 32 0 1 1 0 64z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Finished</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M160 256H96a32 32 0 0 1 0-64h256V95.936a32 32 0 0 1 32-32h256a32 32 0 0 1 32 32V192h256a32 32 0 1 1 0 64h-64v672a32 32 0 0 1-32 32H192a32 32 0 0 1-32-32zm448-64v-64H416v64zM224 896h576V256H224zm192-128a32 32 0 0 1-32-32V416a32 32 0 0 1 64 0v320a32 32 0 0 1-32 32m192 0a32 32 0 0 1-32-32V416a32 32 0 0 1 64 0v320a32 32 0 0 1-32 32"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Delete</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M256 768h672a32 32 0 1 1 0 64H224a32 32 0 0 1-32-32V96a32 32 0 0 1 64 0z"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M832 224v704a32 32 0 1 1-64 0V256H96a32 32 0 0 1 0-64h704a32 32 0 0 1 32 32"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Crop</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M352 159.872V230.4a352 352 0 1 0 320 0v-70.528A416.128 416.128 0 0 1 512 960a416 416 0 0 1-160-800.128z"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M512 64q32 0 32 32v320q0 32-32 32t-32-32V96q0-32 32-32"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >SwitchButton</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M389.44 768a96.064 96.064 0 0 1 181.12 0H896v64H570.56a96.064 96.064 0 0 1-181.12 0H128v-64zm192-288a96.064 96.064 0 0 1 181.12 0H896v64H762.56a96.064 96.064 0 0 1-181.12 0H128v-64zm-320-288a96.064 96.064 0 0 1 181.12 0H896v64H442.56a96.064 96.064 0 0 1-181.12 0H128v-64z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Operation</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M329.956 257.138a254.862 254.862 0 0 0 0 509.724h364.088a254.862 254.862 0 0 0 0-509.724zm0-72.818h364.088a327.68 327.68 0 1 1 0 655.36H329.956a327.68 327.68 0 1 1 0-655.36z"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M694.044 621.227a109.227 109.227 0 1 0 0-218.454 109.227 109.227 0 0 0 0 218.454m0 72.817a182.044 182.044 0 1 1 0-364.088 182.044 182.044 0 0 1 0 364.088"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Open</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M352 480h320a32 32 0 1 1 0 64H352a32 32 0 0 1 0-64"
                                ></path>
                                <path
                                    fill="currentColor"
                                    d="M512 896a384 384 0 1 0 0-768 384 384 0 0 0 0 768m0 64a448 448 0 1 1 0-896 448 448 0 0 1 0 896"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Remove</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="m795.904 750.72 124.992 124.928a32 32 0 0 1-45.248 45.248L750.656 795.904a416 416 0 1 1 45.248-45.248zM480 832a352 352 0 1 0 0-704 352 352 0 0 0 0 704M352 448h256a32 32 0 0 1 0 64H352a32 32 0 0 1 0-64"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >ZoomOut</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="m795.904 750.72 124.992 124.928a32 32 0 0 1-45.248 45.248L750.656 795.904a416 416 0 1 1 45.248-45.248zM480 832a352 352 0 1 0 0-704 352 352 0 0 0 0 704m-32-384v-96a32 32 0 0 1 64 0v96h96a32 32 0 0 1 0 64h-96v96a32 32 0 0 1-64 0v-96h-96a32 32 0 0 1 0-64z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >ZoomIn</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 64a448 448 0 1 1 0 896.064A448 448 0 0 1 512 64m67.2 275.072c33.28 0 60.288-23.104 60.288-57.344s-27.072-57.344-60.288-57.344c-33.28 0-60.16 23.104-60.16 57.344s26.88 57.344 60.16 57.344M590.912 699.2c0-6.848 2.368-24.64 1.024-34.752l-52.608 60.544c-10.88 11.456-24.512 19.392-30.912 17.28a12.992 12.992 0 0 1-8.256-14.72l87.68-276.992c7.168-35.136-12.544-67.2-54.336-71.296-44.096 0-108.992 44.736-148.48 101.504 0 6.784-1.28 23.68.064 33.792l52.544-60.608c10.88-11.328 23.552-19.328 29.952-17.152a12.8 12.8 0 0 1 7.808 16.128L388.48 728.576c-10.048 32.256 8.96 63.872 55.04 71.04 67.84 0 107.904-43.648 147.456-100.416z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >InfoFilled</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 64a448 448 0 1 1 0 896 448 448 0 0 1 0-896m-55.808 536.384-99.52-99.584a38.4 38.4 0 1 0-54.336 54.336l126.72 126.72a38.272 38.272 0 0 0 54.336 0l262.4-262.464a38.4 38.4 0 1 0-54.272-54.336z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >CircleCheckFilled</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 64a448 448 0 1 1 0 896 448 448 0 0 1 0-896m-55.808 536.384-99.52-99.584a38.4 38.4 0 1 0-54.336 54.336l126.72 126.72a38.272 38.272 0 0 0 54.336 0l262.4-262.464a38.4 38.4 0 1 0-54.272-54.336z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >SuccessFilled</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 64a448 448 0 1 1 0 896 448 448 0 0 1 0-896m0 192a58.432 58.432 0 0 0-58.24 63.744l23.36 256.384a35.072 35.072 0 0 0 69.76 0l23.296-256.384A58.432 58.432 0 0 0 512 256m0 512a51.2 51.2 0 1 0 0-102.4 51.2 51.2 0 0 0 0 102.4"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >WarningFilled</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 64a448 448 0 1 1 0 896 448 448 0 0 1 0-896m0 393.664L407.936 353.6a38.4 38.4 0 1 0-54.336 54.336L457.664 512 353.6 616.064a38.4 38.4 0 1 0 54.336 54.336L512 566.336 616.064 670.4a38.4 38.4 0 1 0 54.336-54.336L566.336 512 670.4 407.936a38.4 38.4 0 1 0-54.336-54.336z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >CircleCloseFilled</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 64a448 448 0 1 1 0 896 448 448 0 0 1 0-896m23.744 191.488c-52.096 0-92.928 14.784-123.2 44.352-30.976 29.568-45.76 70.4-45.76 122.496h80.256c0-29.568 5.632-52.8 17.6-68.992 13.376-19.712 35.2-28.864 66.176-28.864 23.936 0 42.944 6.336 56.32 19.712 12.672 13.376 19.712 31.68 19.712 54.912 0 17.6-6.336 34.496-19.008 49.984l-8.448 9.856c-45.76 40.832-73.216 70.4-82.368 89.408-9.856 19.008-14.08 42.24-14.08 68.992v9.856h80.96v-9.856c0-16.896 3.52-31.68 10.56-45.76 6.336-12.672 15.488-24.64 28.16-35.2 33.792-29.568 54.208-48.576 60.544-55.616 16.896-22.528 26.048-51.392 26.048-86.592 0-42.944-14.08-76.736-42.24-101.376-28.16-25.344-65.472-37.312-111.232-37.312zm-12.672 406.208a54.272 54.272 0 0 0-38.72 14.784 49.408 49.408 0 0 0-15.488 38.016c0 15.488 4.928 28.16 15.488 38.016A54.848 54.848 0 0 0 523.072 768c15.488 0 28.16-4.928 38.72-14.784a51.52 51.52 0 0 0 16.192-38.72 51.968 51.968 0 0 0-15.488-38.016 55.936 55.936 0 0 0-39.424-14.784z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >QuestionFilled</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                xml:space="preserve"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M928.99 755.83 574.6 203.25c-12.89-20.16-36.76-32.58-62.6-32.58s-49.71 12.43-62.6 32.58L95.01 755.83c-12.91 20.12-12.9 44.91.01 65.03 12.92 20.12 36.78 32.51 62.59 32.49h708.78c25.82.01 49.68-12.37 62.59-32.49 12.91-20.12 12.92-44.91.01-65.03M554.67 768h-85.33v-85.33h85.33zm0-426.67v298.66h-85.33V341.32z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >WarnTriangleFilled</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M288 320a224 224 0 1 0 448 0 224 224 0 1 0-448 0m544 608H160a32 32 0 0 1-32-32v-96a160 160 0 0 1 160-160h448a160 160 0 0 1 160 160v96a32 32 0 0 1-32 32z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >UserFilled</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M176 416a112 112 0 1 1 0 224 112 112 0 0 1 0-224m336 0a112 112 0 1 1 0 224 112 112 0 0 1 0-224m336 0a112 112 0 1 1 0 224 112 112 0 0 1 0-224"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >MoreFilled</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M764.416 254.72a351.68 351.68 0 0 1 86.336 149.184H960v192.064H850.752a351.68 351.68 0 0 1-86.336 149.312l54.72 94.72-166.272 96-54.592-94.72a352.64 352.64 0 0 1-172.48 0L371.136 936l-166.272-96 54.72-94.72a351.68 351.68 0 0 1-86.336-149.312H64v-192h109.248a351.68 351.68 0 0 1 86.336-149.312L204.8 160l166.208-96h.192l54.656 94.592a352.64 352.64 0 0 1 172.48 0L652.8 64h.128L819.2 160l-54.72 94.72zM704 499.968a192 192 0 1 0-384 0 192 192 0 0 0 384 0"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Tools</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M512 128 128 447.936V896h255.936V640H640v256h255.936V447.936z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >HomeFilled</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M160 448a32 32 0 0 1-32-32V160.064a32 32 0 0 1 32-32h256a32 32 0 0 1 32 32V416a32 32 0 0 1-32 32zm448 0a32 32 0 0 1-32-32V160.064a32 32 0 0 1 32-32h255.936a32 32 0 0 1 32 32V416a32 32 0 0 1-32 32zM160 896a32 32 0 0 1-32-32V608a32 32 0 0 1 32-32h256a32 32 0 0 1 32 32v256a32 32 0 0 1-32 32zm448 0a32 32 0 0 1-32-32V608a32 32 0 0 1 32-32h255.936a32 32 0 0 1 32 32v256a32 32 0 0 1-32 32z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Menu</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M544 864V672h128L512 480 352 672h128v192H320v-1.6c-5.376.32-10.496 1.6-16 1.6A240 240 0 0 1 64 624c0-123.136 93.12-223.488 212.608-237.248A239.808 239.808 0 0 1 512 192a239.872 239.872 0 0 1 235.456 194.752c119.488 13.76 212.48 114.112 212.48 237.248a240 240 0 0 1-240 240c-5.376 0-10.56-1.28-16-1.6v1.6z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >UploadFilled</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M628.736 528.896A416 416 0 0 1 928 928H96a415.872 415.872 0 0 1 299.264-399.104L512 704zM720 304a208 208 0 1 1-416 0 208 208 0 0 1 416 0"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Avatar</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M926.784 480H701.312A192.512 192.512 0 0 0 544 322.688V97.216A416.064 416.064 0 0 1 926.784 480m0 64A416.064 416.064 0 0 1 544 926.784V701.312A192.512 192.512 0 0 0 701.312 544zM97.28 544h225.472A192.512 192.512 0 0 0 480 701.312v225.472A416.064 416.064 0 0 1 97.216 544zm0-64A416.064 416.064 0 0 1 480 97.216v225.472A192.512 192.512 0 0 0 322.688 480H97.216z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >HelpFilled</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="m679.872 348.8-301.76 188.608a127.808 127.808 0 0 1 5.12 52.16l279.936 104.96a128 128 0 1 1-22.464 59.904l-279.872-104.96a128 128 0 1 1-16.64-166.272l301.696-188.608a128 128 0 1 1 33.92 54.272z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Share</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M283.84 867.84 512 747.776l228.16 119.936a6.4 6.4 0 0 0 9.28-6.72l-43.52-254.08 184.512-179.904a6.4 6.4 0 0 0-3.52-10.88l-255.104-37.12L517.76 147.904a6.4 6.4 0 0 0-11.52 0L392.192 379.072l-255.104 37.12a6.4 6.4 0 0 0-3.52 10.88L318.08 606.976l-43.584 254.08a6.4 6.4 0 0 0 9.28 6.72z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >StarFilled</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M736 504a56 56 0 1 1 0-112 56 56 0 0 1 0 112m-224 0a56 56 0 1 1 0-112 56 56 0 0 1 0 112m-224 0a56 56 0 1 1 0-112 56 56 0 0 1 0 112M128 128v640h192v160l224-160h352V128z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Comment</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M416 896V128h192v768zm-288 0V448h192v448zm576 0V320h192v576z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Histogram</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M640 384v256H384V384zm64 0h192v256H704zm-64 512H384V704h256zm64 0V704h192v192zm-64-768v192H384V128zm64 0h192v192H704zM320 384v256H128V384zm0 512H128V704h192zm0-768v192H128V128z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Grid</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="m64 448 832-320-128 704-446.08-243.328L832 192 242.816 545.472zm256 512V657.024L512 768z"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >Promotion</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i
                            class="el-icon"
                            data-v-ea893728=""
                            style="font-size: 20px"
                            ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 1024 1024"
                                data-v-ea893728=""
                            >
                                <path
                                    fill="currentColor"
                                    d="M352 192V95.936a32 32 0 0 1 32-32h256a32 32 0 0 1 32 32V192h256a32 32 0 1 1 0 64H96a32 32 0 0 1 0-64zm64 0h192v-64H416zM192 960a32 32 0 0 1-32-32V256h704v672a32 32 0 0 1-32 32zm224-192a32 32 0 0 0 32-32V416a32 32 0 0 0-64 0v320a32 32 0 0 0 32 32m192 0a32 32 0 0 0 32-32V416a32 32 0 0 0-64 0v320a32 32 0 0 0 32 32"
                                ></path></svg></i
                        ><span class="icon-name" data-v-ea893728=""
                            >DeleteFilled</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        >
                        <i-ep-RemoveFilled style="font-size: 20px" />
                        <span class="icon-name" data-v-ea893728=""
                            >RemoveFilled</span
                        ></span
                    >
                </li>
                <li class="icon-item" data-v-ea893728="">
                    <span class="demo-svg-icon" data-v-ea893728=""
                        ><i-ep-CirclePlusFilled style="font-size: 20px" /><span class="icon-name" data-v-ea893728=""
                            >CirclePlusFilled</span
                        ></span
                    >
                </li>
            </ul>
        </div>
    </div>
</template>
<script setup lang="ts">
import { getIcon } from "@/api/test/index";
const dataList = ref();
function initData() {
    getIcon().then(({ data }) => {
        dataList.value = data;
    });
}
import { ElIcon } from 'element-plus';

// 获取所有图标名称
const iconNames: string[] = Object.keys(ElIcon).filter((key) => typeof ElIcon[key] === 'string');

console.log("iconNames",iconNames);
onMounted(() => {
    initData();
});
</script>
<style lang="scss" scoped>
.demo-icon-list[data-v-ea893728] {
    overflow: hidden;
    list-style: none;
    padding: 0!important;
    border-top: 1px solid var(--el-border-color);
    border-left: 1px solid var(--el-border-color);
    border-radius: 4px;
    display: grid;
    grid-template-columns: repeat(7,1fr)
}

.demo-icon-list .icon-item[data-v-ea893728] {
    text-align: center;
    color: var(--el-text-color-regular);
    height: 90px;
    font-size: 13px;
    border-right: 1px solid var(--el-border-color);
    border-bottom: 1px solid var(--el-border-color);
    transition: background-color var(--el-transition-duration)
}

.demo-icon-list .icon-item[data-v-ea893728]:hover {
    background-color: var(--el-border-color-extra-light);
    color: var(--brand-color-light)
}

.demo-icon-list .icon-item:hover .el-icon[data-v-ea893728] {
    color: var(--brand-color-light)
}

.demo-icon-list .icon-item .demo-svg-icon[data-v-ea893728] {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100%;
    cursor: pointer
}

.demo-icon-list .icon-item .demo-svg-icon .icon-name[data-v-ea893728] {
    margin-top: 8px
}

</style>
