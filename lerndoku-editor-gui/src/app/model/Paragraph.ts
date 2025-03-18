export type Options = 'h1' | 'h2' | 'h3' | 'p' | string;

export default interface Paragraph {
    content: string;
    option: Options;
}
