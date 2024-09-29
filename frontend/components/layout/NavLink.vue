<script setup lang="ts">

</script>

<template>

    <section class="overflow-hidden w-full h-full flex flex-col justify-center items-center relative">
        <div class="w-full xl:w-1/2  self-start px-16 lg:px-32 2xl:px-48 mb-32">
            <H2 class="mt-4">Welcome To</H2>
            <H1>{headerData.title}</H1>
            <p class="-mt-24 md:-mt-12 mb-32 rich-text" v-html={documentToHtmlString(headerData.description.json)}></p>
        </div>
        <Image
            src={headerImageBlob}
            alt="Blob"
            loading="eager"
            class="hidden xl:block w-2/3 h-full aspect-square absolute bottom-0 -right-[20%] z-[100] object-cover -translate-y-[10%]"
        />
        <Image
            src={headerImage}
            alt="Wawel"
            loading="eager"
            format="webp"
            class="hidden xl:block w-2/3 h-full aspect-square absolute bottom-0 -right-[20%] z-[100] object-cover -translate-y-[10%] blob-clip"
        />

        <Image
            onclick="document.querySelector('[data-subpage-start]').scrollIntoView({ behavior: 'smooth', block: 'start' })"
            class="absolute bottom-32 xl:bottom-48 left-1/2 -translate-x-1/2 w-[100px] h-[125px] cursor-pointer hidden sm:block"
            src={headerScrollIcon}
            loading="eager"
            alt="Does nothing"
        />
    </section>

    <style>
        .blob-clip {
            //clip-path: url(#blobClip);
            //width: 66%; /* Ensure the image stretches as needed */
            //height: 100%; /* Maintain the aspect ratio */
            object-fit: cover; /* Ensure the image covers the entire blob shape */
            object-position: bottom; /* Center the image within the blob */
            transform: translateY(-10%); /* Adjust this value to move the image up or down */
            -webkit-mask-image: url('/blob.svg');
            -webkit-mask-size: cover;
            -webkit-mask-position: center;
            -webkit-mask-repeat: no-repeat;
        }
        .hero-image {
            -webkit-mask-image: url('/blob.svg');
            -webkit-mask-size: contain;
            -webkit-mask-repeat: no-repeat;
        }
    </style>
</template>

<style scoped>

</style>