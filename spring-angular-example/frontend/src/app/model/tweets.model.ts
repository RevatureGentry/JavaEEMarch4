export interface Tweet {
    tweetId?: number;
    content: string;
    timestamp?: number;
    username?: string;
    comments?: Comment[];
}