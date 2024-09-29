export const stripHtmlTags = (input: string): string => {
    if (input == null) return '';
    return input.replace(/<[^>]*>/g, '');
}