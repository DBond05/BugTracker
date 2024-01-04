export class Bug {
    constructor(
        public id: number,
        public projectName: string,
        public issueType: string,
        public description: string,
        public troubleshooting: string,
        public resolution: string,
        public resolved: boolean,
        public recordedDate: Date,
        public updateDate: Date 
    ){}
}
