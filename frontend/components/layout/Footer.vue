<template>
    <div class="w-full py-6 px-14 bg-[#FBFFFC] border-t-[1px] border-[#DEE7D3] flex flex-col xl:flex-row justify-between items-center gap-5 xl:gap-0 text-[#454F45] font-[500]">
        <div>
            <v-icon icon="mdi-circle" color="#454F45" size="x-small"/>
            <span class="ml-4">MindShare, Inc. All rights reserved.</span>
        </div>
        <div class="flex flex-col lg:flex-row gap-6 xl:gap-20">
            <div class="flex flex-row gap-10 justify-center">
                <nuxt-link to="/elearning-course">Full Course List</nuxt-link>
                <nuxt-link to="/about">About MindShare</nuxt-link>
                <nuxt-link to="/careers">Careers with MindShare</nuxt-link>
            </div>

            <div class="flex flex-row gap-10 justify-center">
                <nuxt-link to="/contact">Contact Us</nuxt-link>
                <nuxt-link to="/privacy-policy">Privacy Policy</nuxt-link>
                <nuxt-link to="/terms-of-use">Terms of Use</nuxt-link>
            </div>
        </div>
    </div>
</template>