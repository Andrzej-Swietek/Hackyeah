

<template>

    <section id="hero">
      <div class="container">
        <Nav/>
        <div class="hero__text">
          <div class="sub__header">


          </div>
          <h1 class="hero__header">We enable rapid growth digital creation</h1>
          <p class="hero__intro">
            Lorem ipsum dolor sit amet consectetur adipisicing elit.
            Consequatur fugit illum vel provident! Incidunt doloribus iusto, earum saepe minus architecto
            vero repellat aliquid, officiis nemo adipisci ex perferendis possimus aut.
          </p>
        </div>
        <div class="image__container">
          <svg class="main__hero__image" width="100%" height="100%" viewBox="0 0 100 40">
            <clipPath id="border">
              <path id="main__image__path"
                    d="M 7 5
                                   L 85 5
                                   A 2.5 2.5 0 0 0 87.5 2.5
                                   A 2.5 2.5 0 0 1 90 0
                                   L 97.5 0
                                   A 2.5 2.5 0 0 1 100 2.5
                                   L 100 25
                                   A 2.5 2.5 0 0 1 97.5 27.5
                                   L 80 27.5
                                   A 2.5 2.5 0 0 0 77.5 30
                                   L 77.5 35
                                   A 2.5 2.5 0 0 1 75 37.5
                                   L 10 37.5
                                   A 2.5 2.5 0 0 1 7.5 35
                                   L 7.5 20
                                   A 2.5 2.5 0 0 0 5 17.5
                                   L 2.5 17.5
                                   A 2.5 2.5 0 0 1 0 15
                                   L 0 7.5
                                   A 2.5 2.5 0 0 1 2.5  5
                                "
              />
                <!--
                    M [x] [y] - move
                    L [x] [y] - line to (x,y)
                    A [r_x] [r_y] [direction] [x] [y] - arc of givern radius to point(x,y) in directecton (left/right)
                                    direction: 0 0 0 - counter clockwise
                                    direction: 0 0 1 - clockwise
                -->

            </clipPath>
            <image clip-path="url(#border)" preserveAspectRatio="xMidYMid slice" width="100%" height="100%"
                   xlink:href="https://cdn.prod.website-files.com/63c560228fad5afe6ddbe1a4/646f7b0e442d7e02b27f5d11_ctc-home-header.webp">
            </image>
          </svg>
        </div>
        <div class="carousel">
          <div class="left__carousel"></div>
          <div class="right__carousel"></div>
          <div class="carousel__inner">
            <div class="item"><img src="./assets/logo-move.svg" alt=""></div>
            <div class="item"><img src="./assets/logo-skybox.png" alt=""></div>
            <div class="item"><img src="./assets/logo-swb.svg" alt=""></div>
            <div class="item"><img src="./assets/samsung.svg" alt=""></div>
            <div class="item"><img src="./assets/logo-tas.svg" alt=""></div>
            <div class="item"><img src="./assets/logo-move.svg" alt=""></div>
            <div class="item"><img src="./assets/logo-skybox.png" alt=""></div>
            <div class="item"><img src="./assets/logo-swb.svg" alt=""></div>
            <div class="item"><img src="./assets/samsung.svg" alt=""></div>
            <div class="item"><img src="./assets/logo-tas.svg" alt=""></div>
          </div>
        </div>
      </div>
      <div class="bottom__div">
        <div class="left">
          <div class="curve"></div>
          <div class="cover"></div>
        </div>
        <div class="right">
          <div class="services">
            <h5>Services</h5>
          </div>
        </div>
      </div>
    </section>
    <section id="about">
      <div class="about__container">
        <div class="about__text">
          <h2>
            We create without the need for coding to give ambitious brands the upper hand
          </h2>
        </div>
      </div>
    </section>
</template>
<script setup lang="ts">

import Nav from "~/components/layout/Nav.vue";
</script>
<style scoped>

</style>