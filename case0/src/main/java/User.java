// TODO: create the User class/object
// it must support rank, progress, and the incProgress(int rank) method
public class User {
    int rank;
    int progress;
    // ранжирование от -8 до 8 0 rank не учитывается
    public User(){
        this.rank = -8;
        this.progress = 0;
    }

    public int getRank() {
        return rank;
    }

    public int getProgress() {
        return progress;
    }

    public void incProgress(int activityRank){
        if (activityRank < -8 || activityRank > 8 || activityRank == 0) {
            throw new IllegalArgumentException("Error: Invalid rank: " + activityRank);
        } else {
            int rankDiffernce = activityRank - this.rank;
            int progressToAdd = 0;
            if(rankDiffernce == 0){
                progressToAdd = 3;
            }else if(rankDiffernce == -1){
                progressToAdd = 1;
            }else if(rankDiffernce >= 2){
                progressToAdd = 0;
            }else if(rankDiffernce > 0){
                progressToAdd = 10 * rankDiffernce * rankDiffernce;
            }

            this.progress += progressToAdd;

            while(this.progress >= 100){
                this.progress -= 100;
                if(this.rank < 8){
                    this.rank++;
                }
            }

            if(this.rank == 8){
                this.progress = 0;
            }

            this.progress = 0;

        }
    }

}
