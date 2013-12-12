package com.me.snakage;

import java.util.ArrayList;

public class Snake {

	bodyPart head;

	int insertX;
	int insertY;

	ArrayList<bodyPart> body;

	public Snake(int headX, int headY) {

		head = new bodyPart(headX, headY);

		body = new ArrayList<bodyPart>();

		body.add(head);

	}

	public void addPart() {

		bodyPart current = new bodyPart(insertX, insertY);
		body.add(current);

	}
	
	public boolean checkForBody(int X, int Y, int direction){
		
		int checkX = X;
		int checkY = Y;
		
		switch (direction) {

		case 0:
			checkX -= 30;
			break;
		case 1:
			checkY += 30;
			break;
		case 2:
			checkX += 30;
			break;
		case 3:
			checkY -= 30;
			break;
			
		case 4:
			break;

		}

		for (int i = 1; i < body.size(); i++) {
			
			if (body.get(i).bpX == checkX && body.get(i).bpY == checkY){
				return true;
			}
			
		}
		
		return false;
	}

	public void update(int direction) {

		int oldbodyX = head.bpX;
		int oldbodyY = head.bpY;

		int nextX = 0;
		int nextY = 0;

		switch (direction) {

		case 0:
			head.bpX -= 30;
			break;
		case 1:
			head.bpY += 30;
			break;
		case 2:
			head.bpX += 30;
			break;
		case 3:
			head.bpY -= 30;
			break;

		}

		head.bpX = head.bpX % 960;
		//head.bpY = head.bpY % 540;

		if (head.bpX < 0) {
			head.bpX = head.bpX + 960;
		}
		if (head.bpY > 540) {
			head.bpY = 60;			
		}
		else if (head.bpY < 60){
			head.bpY = 510;
		}

		if (body.size() > 1) {
			for (int i = 1; i < body.size(); i++) {

				nextX = body.get(i).bpX;
				nextY = body.get(i).bpY;

				body.get(i).bpX = oldbodyX;
				body.get(i).bpY = oldbodyY;

				oldbodyX = nextX;
				oldbodyY = nextY;
			}
		}
		
		insertX = oldbodyX;
		insertY = oldbodyY;

	}

}
