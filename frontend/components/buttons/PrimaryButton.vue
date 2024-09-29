<template>
    <component
        :is="href ? 'router-link' : 'button'"
        :to="href"
        :class="[
      variantStyle,
      commonStyle,
      styles,
      disabled && disabledStyle
    ]"
        :type="buttonType"
        @click="onClick"
        :disabled="disabled"
    >
        {{ value }}
    </component>
</template>

<script setup>
import { computed } from 'vue';
import { useRouter } from 'vue-router';

// Define props
const props = defineProps({
    buttonType: { type: String, default: 'button' },
    onClick: { type: Function, default: () => {} },
    variant: { type: String, default: 'filled' },
    color: { type: String, default: 'primary' },
    styles: { type: String, default: '' },
    disabled: { type: Boolean, default: false },
    value: { type: String, required: true },
    href: { type: String, default: '' }
});

// Vue router setup
const router = useRouter();

// Common button style
const commonStyle = 'flex-center text-center text-xs lg:text-base xl:text-lg font-bold py-2 px-2 lg:py-2 lg:px-3 xl:px-4 rounded-[30px] cursor-pointer duration-300 ease-in-out';

// Variant styles
const filledStyle = computed(() =>
    props.color === 'red'
        ? 'bg-error focus:bg-errorContainer focus:text-error text-white hover:shadow-base'
        : 'bg-primary focus:bg-primaryContainer focus:text-primary text-white hover:shadow-base'
);
const outlinedStyle = computed(() =>
    props.color === 'red'
        ? 'text-error border-error hover:bg-errorContainer focus:bg-errorContainer'
        : 'text-primary border-primary hover:bg-primaryContainer focus:bg-primaryContainer bg-white border'
);
const textStyle = computed(() =>
    props.color === 'red'
        ? 'text-error hover:bg-errorContainer focus:bg-errorContainer active:bg-errorContainer'
        : 'text-primary hover:bg-primaryContainer focus:bg-primaryContainer active:bg-primaryContainer'
);
const elevatedStyle = computed(() =>
    props.color === 'red'
        ? 'text-error bg-errorContainer hover:bg-errorContainer'
        : 'text-primary bg-primaryContainer hover:bg-primaryContainer shadow-base'
);
const tonalStyle = 'text-secondary bg-[#CEE6FF] hover:bg-[#66b2ff] hover:shadow-base focus:bg-[#66b2ff]';
const disabledStyle = '!bg-[#eee] !text-neutral !cursor-default !border-none';
const orangeStyle = 'text-[#fff] bg-error hover:bg-errorContainer hover:shadow-base focus:bg-errorContainer';

// Computed variantStyle based on variant prop
const variantStyle = computed(() => {
    switch (props.variant) {
        case 'outlined':
            return outlinedStyle.value;
        case 'text':
            return textStyle.value;
        case 'elevated':
            return elevatedStyle.value;
        case 'tonal':
            return tonalStyle;
        case 'orange':
            return orangeStyle;
        default:
            return filledStyle.value;
    }
});
</script>

<style scoped>
.flex-center {
    display: flex;
    align-items: center;
    justify-content: center;
}
</style>
