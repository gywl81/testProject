package com.sktelecom.tdrive;

public class TmapMain {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		double mCoordX = (double) 4629413 / 36000;
		double mCoordY = (double) 1291912 / 36000;
		
		
		System.out.println("mCoordX WGS84 X 좌표 :: " + mCoordX);
		System.out.println("mCoordYWGS84 Y 좌표 :: " + mCoordY);
		
		
		CoordPoint pt = new CoordPoint(mCoordX, mCoordY);
		CoordPoint besselPt = TransCoord.getTransCoord(pt, TransCoord.COORD_TYPE_BESSEL, TransCoord.COORD_TYPE_WGS84);
		System.out.println("WGS84 X 좌표 :: " + besselPt.x);
		System.out.println("WGS84 Y 좌표 :: " + besselPt.y);
		/*
		1.
		Tmap에서 전달 받은 param :  _lat === :: 1291912
		Tmap에서 전달 받은 param :  _lng === :: 4629413
		carlive 전송 param : {"des_dest":"침산옥석타운아파트","des_lat":35.88644444444444,"des_lng":128.59480555555555}
		2.
		Tmap에서 전달 받은 param :  _lat === :: 1291804
		Tmap에서 전달 받은 param :  _lng === :: 4629493
		carlive 전송 param : {"des_dest":"침산옥석타운아파트","des_lat":35.88344444444444,"des_lng":128.59702777777778}
		3.
		Tmap에서 전달 받은 param :  _lat === :: 1291696
		Tmap에서 전달 받은 param :  _lng === :: 4629573
		carlive 전송 param : {"des_dest":"침산옥석타운아파트","des_lat":35.88044444444444,"des_lng":128.59925}
		*/
	}
}
