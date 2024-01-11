export class Bug {
    public id!: number;
    public projectName!: string;
    public issueType!: string;
    public description!: string;
    public troubleShooting!: string;
    public resolution!: string;
    public resolved!: boolean;
    public recordedDate!: Date;
    public updateDate!: Date; 
    
   
    static displayGetBug(id:number, name:string, type: string, desc:string, 
        tsing:string, resolved:boolean, resolution: string, rdate: Date, udate: Date ):Bug{
         var bug = new Bug();
        bug.id = id;
        bug.projectName = name;
        bug.issueType = type;
        bug.description = desc;
        bug.troubleShooting= tsing;
        bug.resolved = resolved;
        bug.resolution = resolution;
        bug.recordedDate = rdate;
        bug.updateDate = udate;
        return bug;
    }
    static postBug(name: string, type: string, desc:string, 
         tsing:string, resolved:boolean, resolution:string ):Bug{
        var post = new Bug();
        post.projectName = name;
        post.issueType = type;
        post.description = desc;
        post.troubleShooting= tsing;
        post.resolved = resolved;
        post.resolution = resolution;
        return post;
    }

    static putBug(id:number, name:string, type: string, desc:string, 
        tsing:string, resolved:boolean, resolution: string,):Bug{
            var bug = new Bug();
        bug.id = id;
        bug.projectName = name;
        bug.issueType = type;
        bug.description = desc;
        bug.troubleShooting= tsing;
        bug.resolved = resolved;
        bug.resolution = resolution;
        return bug;
        }
    
   
}
