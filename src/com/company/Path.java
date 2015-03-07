package com.company;

class Path {
	String src;
	String dest;

	public Path(String src, String dest) {
		this.src = src;
		this.dest = dest;
	}

	public int hashCode (){
		return this.src.hashCode() + this.dest.hashCode();
	}

	public boolean equals(Path p) {
		if(p == null)
			return false;
		return p.src.equals(src) && p.dest.equals(dest);
	}

	public String toString(){
		return src +" >>>>>>> "+dest;
	}
}