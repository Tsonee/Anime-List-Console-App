package MainApp;

import java.util.ArrayList;
import java.util.Date;

public class AnimeManager
{
    private MyAnime currentlyWatchingAnime;

    private ArrayList<MyAnime> toWatchList;

    private ArrayList<MyAnime> finishedWatchingList;

    public AnimeManager()
    {
        this.currentlyWatchingAnime = null;
        this.toWatchList = new ArrayList<MyAnime>();
        this.finishedWatchingList = new ArrayList<MyAnime>();

    }

    public MyAnime getCurrentlyWatchingAnime()
    {
        return currentlyWatchingAnime;
    }

    public void setCurrentlyWatchingAnime(MyAnime currentlyWatchingAnime)
    {
        this.currentlyWatchingAnime = currentlyWatchingAnime;
    }

    public void printCurrentlyWatchingAnime()
    {
        if(this.currentlyWatchingAnime != null)
        {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Curently watching :");
            currentlyWatchingAnime.currDisplay();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
        }else
        {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Currently watching : NONE");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
        }
    }

    public ArrayList<MyAnime> getToWatchList()
    {
        return this.toWatchList;
    }

    public ArrayList<MyAnime> getFinishedWatchingList()
    {
        return this.finishedWatchingList;
    }

    public void printToWatchList()
    {
        if (!this.toWatchList.isEmpty()) {
            System.out.println("||||||||||||||||||||||||||||||||||||||");
            for (int i = 0; i < this.toWatchList.size(); i++) {
                System.out.println("_____________________________________________");
                System.out.print((i + 1) + ". ");
                toWatchList.get(i).normalDisplay();
                System.out.println("_____________________________________________");
            }
            System.out.println("||||||||||||||||||||||||||||||||||||||");
        }else
        {
            System.out.println("-------------------------------");
            System.out.println("Your To Watch list is empty!");
            System.out.println("-------------------------------");
        }
    }
    public void toWatchListAdd(String name, int season, boolean finishedAiring, int releaseYear, int episodeNumber, String genre)
    {
        this.toWatchList.add((new MyAnime(name,season,finishedAiring,releaseYear,episodeNumber,genre)));
    }

    public void toWatchListAdd(MyAnime anime)
    {
        this.toWatchList.add(anime);
    }

    public void toWatchRemove(String name)
    {
        for(int i = 0; i < this.toWatchList.size(); i++)
        {
            if(this.toWatchList.get(i).name.compareTo(name) == 0)
            {
                this.toWatchList.remove(i);
            }else
            {
                System.out.println("_____________________________________________");
                System.out.println("Anime not found,couldn't remove an anime from the To Watch list!");
                System.out.println("_____________________________________________");
            }
        }
    }

    public void setToCurrentlyWatching(String name)
    {
        for (int i = 0; i < this.toWatchList.size(); i++)
        {
            if (this.toWatchList.get(i).name.compareTo(name) == 0) {
                this.currentlyWatchingAnime = this.toWatchList.get(i);
                this.currentlyWatchingAnime.setStatus(WatchingStatus.CURRENTLYWATCHING);
                this.toWatchList.remove(i);
                break;
            }
            else
            {
                System.out.println("_____________________________________________");
                System.out.println("Anime not found, couldn't set the current anime!");
                System.out.println("_____________________________________________");
            }
        }

    }

    public void finishWatching(Mark mark, MyDate finishDate)
    {
            this.currentlyWatchingAnime.setStatus(WatchingStatus.FINISHED);
            this.currentlyWatchingAnime.setMark(mark);
            this.currentlyWatchingAnime.setFinishDate(finishDate);
            MyAnime res = this.currentlyWatchingAnime;
            this.currentlyWatchingAnime = null;
            this.finishedWatchingList.add(res);
    }

    public void drop()
    {
        this.currentlyWatchingAnime = null;
    }

    public void printFinishedWathingList()
    {
        if (!this.finishedWatchingList.isEmpty()) {
            System.out.println("||||||||||||||||||||||||||||||||||||||");
            for (int i = 0; i < this.finishedWatchingList.size(); i++) {
                System.out.println("_____________________________________________");
                System.out.print((i + 1) + ". ");
                finishedWatchingList.get(i).finishedDisplay();
                System.out.println("_____________________________________________");
            }
            System.out.println("||||||||||||||||||||||||||||||||||||||");
        }else
        {
            System.out.println("-------------------------------");
            System.out.println("Your Finished Watching list is empty!");
            System.out.println("-------------------------------");
        }
    }
}
