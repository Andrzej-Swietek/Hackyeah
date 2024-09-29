export const isZipCode = (text: string) => {
    const regex = /^\d{2,5}(?:-\d{1,4})?$/;
    return regex.test(text)
}

export const optionalZipCode = (text: string) => {
    return !text ? true : isZipCode(text);
}

export function isPhoneNumber(text: string) {
    const regex = /^\+?[0-9\s-]{7,20}$/;
    return regex.test(text);
}

export const optionalPhoneNumber = (text: string) => {
    return !text ? true : isPhoneNumber(text);
}