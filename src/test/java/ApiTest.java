import org.junit.Test;

import com.sktelecom.tdrive.CallMusicMateApi;
import com.sktelecom.tdrive.TmapApi;
//@RunWith(MockitoJUnitRunner.class)
public class ApiTest {
//	Tmap
	@Test
	public void tmapRouteTest() {
		TmapApi.tmapRoute();
	}
//	API 1 - music_ticket : 99를 제외 하고 start_date, end_date 필수
//	@Test
	public void registerTest() {
		CallMusicMateApi.register();
	}
//	API 2 - music_ticket : 99를 제외 하고 start_date, end_date 필수
//	@Test
	public void sessionTest() {
		CallMusicMateApi.session();
	}
//	API 3
//	@Test
	public void sessionChkTest() {
		CallMusicMateApi.sessionChk();
	}
//	API 4
//	@Test
	public void logoutTest() {
		CallMusicMateApi.logout();
	}
//	API 5
//	@Test
	public void unRegisterTest() {
		CallMusicMateApi.unRegister();
	}
//	API 6
//	@Test
	public void sessionRenewTest() {
		CallMusicMateApi.sessionRenew();
	}
//	API 7
//	@Test
	public void imageUploadTest() {
		CallMusicMateApi.imageUpload();
	}
//	API 8
//	@Test
	public void userSettingSelectTest() {
		CallMusicMateApi.userSettingSelect();
	}
//	API 10
//	@Test
	public void serviceTest() {
		CallMusicMateApi.serviceable();
	}
//	API 17
//	@Test
	public void representListTest() {
		CallMusicMateApi.representList();
	}
//	API 18
//	@Test
	public void categoryTest() {
		CallMusicMateApi.categoryList();
	}
//	API 19
//	@Test
	public void themeListTest() {
		CallMusicMateApi.themeList();
	}
//	API 20
//	@Test
	public void categoryChannelListTest() {
		CallMusicMateApi.categoryChannelList();
	}
//	API 21
//	@Test
	public void themeChannelListTest() {
		CallMusicMateApi.themeChannelList();
	}
//	API 22
//	@Test
	public void channelSearchTest() {
		CallMusicMateApi.channelSearch();
	}
//	API 24
//	@Test
	public void channelListTest() {
		CallMusicMateApi.channelList();
	}
//	API 25
//	@Test
	public void favoritesTest() {
		CallMusicMateApi.favorites();
	}
//	API 26
//	@Test
	public void favoritesUnMarkTest() {
		CallMusicMateApi.favoritesUnMark();
	}
//	API 27
//	@Test
	public void channelHistoryListTest() {
		CallMusicMateApi.channelHistoryList();
	}
}
