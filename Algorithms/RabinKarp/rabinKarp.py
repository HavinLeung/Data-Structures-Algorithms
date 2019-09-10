# input: Text T, pattern P. 
# Output: first index where P occurs in T, or -1 otherwise

def hash(pattern):
	prime = 19484123 # TODO: actually put a large prime here
	radix = 256
	hashval = 0
	for i, c in enumerate(pattern):
		hashval = (hashval + int(c) * radix**i) % prime
	return hashval

def rabin_karp(text, pattern):
	assert(type(text) is str)
	assert(type(pattern) is str)

	if len(text) < len(pattern):
		return -1

	prime = 19484123 # TODO: actually put a large prime here
	radix = 256
	text_length = len(text)
	pattern_hash = hash(pattern)
	rolling_hash = hash(text[0:len(pattern):])
	MSD = radix**(len(pattern)-1) % prime # allows for quick pop of "MSD" of rolling hash

	for i in range(len(text)):
		# i is the most significant character
		if i + len(pattern) > len(text): # can't find a match 
			return -1
		elif rolling_hash == pattern_hash and text[i:i+len(pattern):] == pattern:
			return i
		else: # compute next rolling hash
			rolling_hash = (rolling_hash - MSD*int(text[i])) % prime
			rolling_hash = (rolling_hash*radix) % prime
			rolling_hash = (rolling_hash + int(text[i+len(pattern)])) % prime

print(rabin_karp("abcdabcd", "abcd"))