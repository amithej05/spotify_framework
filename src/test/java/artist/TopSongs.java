package artist;

import org.testng.annotations.Test;

import genenricLibraries.BaseClass;
import objectRepo.ArtistSongViewsPage;
import objectRepo.HomePageAftrLgn;

public class TopSongs extends BaseClass {

	@Test
	public void TopSongs() throws Exception {

		Thread.sleep(3000);
		//read data from excel
		String artist=elib.readDataFromExcel("Artist", 0, 0);
		//enter artist  name into textfield
		HomePageAftrLgn hpl=new HomePageAftrLgn(driver);
		hpl.searchArtist(artist);
		Thread.sleep(3000);
		//click on the artist name
		hpl.getArtName().click();
		Thread.sleep(3000);
		//write data into excel
		ArtistSongViewsPage ap=new ArtistSongViewsPage(driver);
		elib.writemultipleDataIntoExcel("Pritam", "Songs", "Views", 1, 0, 1, ap.getSongs(), ap.getViews());
		//clicking in the home btn
		ap.getHomeBtn().click();

		//2nd artist
		String artist1=elib.readDataFromExcel("Artist", 1, 0);
		//enter artist  name into textfield
		hpl.searchArtist(artist1);
		Thread.sleep(3000);
		//click on the artist name
		hpl.getArtName().click();
		Thread.sleep(3000);
		//write data into excel
		elib.writemultipleDataIntoExcel("Arijit Singh", "Songs", "Views", 1, 0, 1, ap.getSongs(), ap.getViews());
		//clicking in the home btn
		ap.getHomeBtn().click();

		//3rd artist
		String artist2=elib.readDataFromExcel("Artist", 2, 0);
		//enter artist  name into textfield
		hpl.searchArtist(artist2);
		Thread.sleep(3000);
		//click on the artist name
		hpl.getArtName().click();
		Thread.sleep(3000);
		//write data into excel
		elib.writemultipleDataIntoExcel("Sachin-Jigar", "Songs", "Views", 1, 0, 1, ap.getSongs(), ap.getViews());
	}
}
