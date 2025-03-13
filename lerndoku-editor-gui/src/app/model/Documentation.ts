export enum DocumentationState {
    OPEN = 'OPEN',
    EXPORTED = 'EXPORTED',
}

export default interface Documentation {
    id: number;
    title: string;
    semester: number;
    state: DocumentationState;
    createdAt: Date;
}
