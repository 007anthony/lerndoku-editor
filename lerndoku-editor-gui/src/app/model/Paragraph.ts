export type Options = 'h1' | 'h2' | 'h3' | 'p' | string;

export default interface IParagraph {
    content?: string;
    option: Options;
}
